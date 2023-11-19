package com.example.demo.controller;

import com.example.demo.entity.Basis;
import com.example.demo.entity.TS;
import com.example.demo.repository.BasisRepository;
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
public class BasisController {

    @Autowired
    private BasisRepository basisRepository;

    //API 1번. parameter로 받은 bookcode와 date가 일치하고 visited = "0"(아직 안 받은 로그)인 row 중 id가 가장 작은 것(시간상 가장 오래된 로그) 하나만 return
    @GetMapping("/api/v1/get/basis")
    public Basis basis_one(@RequestParam String date, @RequestParam String time){
        return basisRepository.returnone( date, time);
    }

}