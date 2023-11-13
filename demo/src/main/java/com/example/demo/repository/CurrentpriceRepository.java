package com.example.demo.repository;

import com.example.demo.entity.Currentprice;
import com.example.demo.entity.Currentpriceid;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface CurrentpriceRepository extends CrudRepository<Currentprice, Long> {

}