package com.example.demo.repository;


import com.example.demo.entity.TS;
import com.example.demo.entity.Totalasset;
import com.example.demo.entity.Totalassetid;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface TotalassetRepository extends CrudRepository<Totalasset, Totalassetid> {

    //API 5번. 북코드 + 날짜 (합성 PK)를 이용하여 Table row 단순 GET
    @Query(value = "SELECT * FROM totalasset WHERE date = ?1 and sbookcode = ?2", nativeQuery = true)
    ArrayList<Totalasset> get_totalasset(String date, String bookcode);



}
