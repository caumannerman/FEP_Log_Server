package com.example.demo.controller;

import com.example.demo.dto.ArticleDto;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class FirstController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/hi")
    public String niceToMeetYou(){
        return "greetings";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleDto dto){
        log.info(dto.toString());

        //Dto 를 Entity로 변환 .. 그래야 DB에 맵핑 가능하다
        Article article = dto.toEntity();
        log.info(article.toString());
        // Repository에게 Entity를 DB에 저장하게 함
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        return "";
    }

    @PostMapping("/articles/{id}")
    public String show(@PathVariable Long id){
        log.info("id = " + id);

        //id로 데이터 가져옴
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //가져온 데이터를 모델에 등록
        return "";
    }

    @GetMapping("/articles")
    public String index(){
        //모든 Article을 가져온다.
        List<Article> articleEntityList = articleRepository.findAll();

        //가져온 Article 묶음을 뷰로 전달

        // 뷰 페이지를 설정


        return "";
    }
}
