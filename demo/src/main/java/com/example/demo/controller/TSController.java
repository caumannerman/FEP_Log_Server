package com.example.demo.controller;

import com.example.demo.entity.Article;
import com.example.demo.entity.TS;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.TSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // RestAPI용 컨트롤러 JSON을 반환
public class TSController {

    @Autowired
    private TSRepository tsRepository;

    @GetMapping("/api/v1/ts/{id}")
    public TS ts_one(@PathVariable Long id){
        return tsRepository.findById(id).orElse(null);
    }

}
