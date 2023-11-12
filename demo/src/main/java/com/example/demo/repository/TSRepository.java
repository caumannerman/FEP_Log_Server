package com.example.demo.repository;


import com.example.demo.entity.TS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TSRepository extends CrudRepository<TS, Long> {

    @Query(value = "SELECT * from ts where date = '231101' limit 1", nativeQuery = true)
    TS returnonets();
}
