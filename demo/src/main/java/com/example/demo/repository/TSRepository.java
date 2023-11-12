package com.example.demo.repository;


import com.example.demo.entity.TS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface TSRepository extends CrudRepository<TS, Long> {

    @Query(value = "SELECT * from ts where date = ?1 limit 1", nativeQuery = true)
    TS returnonets( String date);
}
