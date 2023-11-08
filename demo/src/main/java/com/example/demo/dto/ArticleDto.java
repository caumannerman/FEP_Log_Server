package com.example.demo.dto;


import com.example.demo.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleDto {
    private String title;
    private String content;

    //dto 객체를 db에 맵핑할 수 있게 Entity로 바꿔줌
    public Article toEntity(){
        return new Article(null, title, content);
    }


}
