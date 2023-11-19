package com.example.demo.repository;

import com.example.demo.entity.Basis;
import com.example.demo.entity.TS;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface BasisRepository extends CrudRepository<Basis, Long> {
    @Query(value = "SELECT * FROM basis WHERE date = ?1 and time > ?2 order by time asc limit 1 ", nativeQuery = true)
    Basis returnone( String date, String time);

}