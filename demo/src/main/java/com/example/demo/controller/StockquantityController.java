package com.example.demo.controller;

import com.example.demo.repository.FuturesquantityRepository;
import com.example.demo.repository.StockquantityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController // RestAPI용 컨트롤러 JSON을 반환
public class StockquantityController {

    @Autowired
    private StockquantityRepository stockquantityRepository;

}