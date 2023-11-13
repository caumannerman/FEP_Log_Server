package com.example.demo.repository;


import com.example.demo.entity.Totalasset;
import com.example.demo.entity.Totalassetid;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface TotalassetRepository extends CrudRepository<Totalasset, Totalassetid> {

    //API 5번. 북코드 + 날짜 (합성 PK)를 이용하여 Table row 단순 GET
    @Query(value = "SELECT * FROM totalasset WHERE date = ?1 and sbookcode = ?2", nativeQuery = true)
    ArrayList<Totalasset> get_bookasset(String date, String bookcode);

    //API4번에서 사용하는, issuecode와 date로 해당 issuecode에 대한 Row 하나만 return해주는 쿼리
    @Query(value = "SELECT * FROM totalasset WHERE date = ?1 and sissuecode = ?2", nativeQuery = true)
    Totalasset get_oneasset(String date, String issuecode);


}
