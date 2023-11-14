package com.example.demo.repository;

import com.example.demo.entity.Currentprice;

import com.example.demo.entity.TS;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface CurrentpriceRepository extends CrudRepository<Currentprice, Long> {
    //API 6번. issuecode,date, time을 parameter로 받아와, 그 시각 보다 크면서 가장 가까운 현재가 return
    @Query(value = "SELECT * FROM currentprice WHERE issuecode = ?1 and date = ?2 and time >= ?3 ORDER BY time ASC LIMIT 1", nativeQuery = true)
    Currentprice returncp(String issuecode, String date, String time);
}