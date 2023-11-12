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

@Slf4j
@RestController // RestAPI용 컨트롤러 JSON을 반환
public class TotalassetController {

    @Autowired
    private TotalassetRepository totalassetRepository;

    @GetMapping("/api/v1/totalasset/{id}")
    public Totalasset ts_one(@PathVariable Totalassetid taid){
        return totalassetRepository.findById(taid).orElse(null);
    }
//
//    // Request의 body에서 받아온 json을 Post해줌
//    @PostMapping("/api/v1/totalasset")
//    public Totalasset create(@RequestBody TotalassetDto dto){
//
//        Totalasset totalasset = dto.toEntity();
//        return totalassetRepository.save( totalasset);
//    }
//
//    @PatchMapping("/api/v1/totalasset/{id}")
//    public ResponseEntity<Totalasset> update(@PathVariable String id, @RequestBody TotalassetDto dto){
//
//        //수정용ㅇ entity 생성
//        Totalasset totalasset = dto.toEntity();
//        log.info("id: {}, ts: {}", id, totalasset.toString());
//        //대상 엔티티 조회
//        Totalasset target = totalassetRepository.findById(id).orElse(null);
//        //잘못된 요청 처리(대상이 없거나 id 다른경우))
//        if(target == null || id != totalasset.getSissuecode()){
//            log.info("잘못된 요청! id: {}, ts: {}", id, totalasset.toString());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//
//        }
//
//        // 업데이트 및 정상응답
//
//        Totalasset updated = totalassetRepository.save(totalasset);
//        return ResponseEntity.status(HttpStatus.OK).body(updated);
//    }


}
