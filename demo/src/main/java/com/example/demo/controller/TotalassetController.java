package com.example.demo.controller;

import com.example.demo.dto.TSDto;
import com.example.demo.dto.TotalassetDto;
import com.example.demo.entity.TS;
import com.example.demo.entity.Totalasset;
import com.example.demo.entity.Totalassetid;
import com.example.demo.repository.TotalassetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController // RestAPI용 컨트롤러 JSON을 반환
public class TotalassetController {

    @Autowired
    private TotalassetRepository totalassetRepository;

    //API 4번. API1번에서 호출한, 방문하지 않았던 로그 json을 사용해서 북코드, 날짜를 PK로 하여 매도수량, 매도금액 PATCH해주면 됨.
//    @PatchMapping("/api/v1/patch/totalasset")
//    public ResponseEntity<Totalasset> update(@RequestParam String bookcode, @RequestParam String date,@RequestParam String buyquantity, @RequestBody TotalassetDto dto){
//
//        //대상 엔티티 조회
//        Totalasset target = totalassetRepository.get_totalasset(date, bookcode);
//
//        //변경할 부분 변경..
//        //target.setBuyquantity(Integer.parseInt(buyquantity));
//
//        // 업데이트 및 정상 응답
//        Totalasset updated = totalassetRepository.save(target);
//        return ResponseEntity.status(HttpStatus.OK).body(updated);
//
//    }

    //API 5번. 북코드 + 날짜 (합성 PK)를 이용하여 Table row 단순 GET
    @GetMapping("/api/v1/get/totalasset")
    public List<Totalasset> ts_one(@RequestParam String bookcode, @RequestParam String date){
        return totalassetRepository.get_totalasset(date, bookcode);
    }
}
