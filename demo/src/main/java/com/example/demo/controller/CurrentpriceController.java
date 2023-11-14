package com.example.demo.controller;

import com.example.demo.entity.TS;
import com.example.demo.repository.CurrentpriceRepository;
import com.example.demo.repository.TSRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController // RestAPI용 컨트롤러 JSON을 반환
public class CurrentpriceController {

    @Autowired
    private CurrentpriceRepository currentpriceRepository;

    //API 6번. issuecode,date, time을 parameter로 받아와, 그 시각 보다 크면서 가장 가까운 현재가
    @GetMapping("/api/v1/get/currentprice")
    public TS currentprice_one(@RequestParam String issuecode, @RequestParam String date, @RequestParam String time){
        return currentpriceRepository.returncp( issuecode, date, time);
    }


}
