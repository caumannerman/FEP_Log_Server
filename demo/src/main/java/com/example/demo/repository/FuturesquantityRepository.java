package com.example.demo.repository;

import com.example.demo.entity.Basis;
import com.example.demo.entity.Futuresquantity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface FuturesquantityRepository extends CrudRepository<Futuresquantity, Long> {

    @Query(value = "SELECT * FROM futuresquantity WHERE date = ?1 and time >= ?2 order by time asc limit 1 ", nativeQuery = true)
    Futuresquantity returnone(String date, String time);



}