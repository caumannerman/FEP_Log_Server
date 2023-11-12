package com.example.demo.controller;

import com.example.demo.dto.TSDto;
import com.example.demo.dto.TotalassetDto;
import com.example.demo.entity.Article;
import com.example.demo.entity.TS;
import com.example.demo.entity.Totalasset;
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

    //API 1번. parameter로 받은 bookcode와 date가 일치하고 visited = "0"(아직 안 받은 로그)인 row 중 id가 가장 작은 것(시간상 가장 오래된 로그) 하나만 return
    @GetMapping("/api/v1/get/notvisited1")
    public TS ts_one(@RequestParam String bookcode, @RequestParam String date){
        return tsRepository.returnonets( date, bookcode);
    }



    // API 2번. 1번 api를 받고, id와 visited="1"만 json에 넣어 PATCH해주는 요청
    // 사실 visited라는 것은 Table을 별도로 두어야 맞지만( 사람1이 visited한 것이 사람2에게 영향 주면 안되므로) 여기서는 그냥 한 사람만 사용한다 침..
    @PatchMapping("/api/v1/patch/logvisited")
    public ResponseEntity<TS> update(@RequestParam String id){

        //대상 엔티티 조회
        TS target = tsRepository.findById((long) Integer.parseInt(id)).orElse(null);

        //변경할 부분 변경..
        target.setVisited("1");

        // 업데이트 및 정상 응답
        TS updated = tsRepository.save(target);
        return ResponseEntity.status(HttpStatus.OK).body(updated);

    }



    // API 3번. parameter로 받은 bookcode와 date가 일치하고 visited = "1"(받은 로그)인 row 30개를 return
    @GetMapping("/api/v1/get/visited30")
    public List<TS> get_notvisited30(@RequestParam String bookcode, @RequestParam String date){
        return tsRepository.get_visited_logs(date, bookcode);
    }





}
