package com.example.demo.controller;

import com.example.demo.dto.ArticleDto;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // RestAPI용 컨트롤러 JSON을 반환
public class FirstApiController {

    @Autowired
    private ArticleRepository articleRepository;
    //GET
    @GetMapping("/api/v1/articles")
    public List<Article> index(){
        return articleRepository.findAll();
    }

    //PathVariable : url에서 받아옴
    @GetMapping("/api/v1/articles/{id}")
    public Article index(@PathVariable Long id){
        return articleRepository.findById(id).orElse(null);
    }

    //RequestBody : body에서 받아옴
    @PostMapping("/api/v1/articles")
    public Article create(@RequestBody ArticleDto dto){
        //dto를 entity로 변환 후 DB에 저장
        Article article = dto.toEntity();
        return articleRepository.save(article);
    }

}
