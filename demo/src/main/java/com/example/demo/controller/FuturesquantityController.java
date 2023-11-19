package com.example.demo.controller;

import com.example.demo.entity.Basis;
import com.example.demo.entity.Futuresquantity;
import com.example.demo.repository.BasisRepository;
import com.example.demo.repository.FuturesquantityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@Slf4j
@RestController // RestAPI용 컨트롤러 JSON을 반환
public class FuturesquantityController {

    @Autowired
    private FuturesquantityRepository futuresquantityRepository;


    //API 1번. parameter로 받은 bookcode와 date가 일치하고 visited = "0"(아직 안 받은 로그)인 row 중 id가 가장 작은 것(시간상 가장 오래된 로그) 하나만 return
    @GetMapping("/api/v1/get/futuresquantity")
    public Futuresquantity futuresquantity_one(@RequestParam String date, @RequestParam String time){
        return futuresquantityRepository.returnone( date, time);
    }


}