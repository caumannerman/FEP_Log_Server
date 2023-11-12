package com.example.demo.controller;

import com.example.demo.dto.TSDto;
import com.example.demo.entity.Article;
import com.example.demo.entity.TS;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.TSRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController // RestAPI용 컨트롤러 JSON을 반환
public class TSController {

    @Autowired
    private TSRepository tsRepository;

    @GetMapping("/api/v1/ts")
    public TS ts_one(@RequestParam String bookcode, @RequestParam String date){
        return tsRepository.returnonets();
    }

    // Request의 body에서 받아온 json을 Post해줌
    @PostMapping("/api/v1/ts")
    public TS create(@RequestBody TSDto dto){

        TS ts = dto.toEntity();
        return tsRepository.save( ts);
    }

    @PatchMapping("/api/v1/ts/{id}")
    public ResponseEntity<TS> update(@PathVariable Long id, @RequestBody TSDto dto){

        //수정용ㅇ entity 생성
        TS ts = dto.toEntity();
        log.info("id: {}, ts: {}", id, ts.toString());
        //대상 엔티티 조회
        TS target = tsRepository.findById(id).orElse(null);
        //잘못된 요청 처리(대상이 없거나 id 다른경우))
        if(target == null || id != ts.getId()){
            log.info("잘못된 요청! id: {}, ts: {}", id, ts.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }

        // 업데이트 및 정상응답

        TS updated = tsRepository.save(ts);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }


}
