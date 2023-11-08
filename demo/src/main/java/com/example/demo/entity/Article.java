package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

//Entity 어노테이션을 붙여줘야 객체들을 DB로 맵핑할 수 있다.
//해당 클래스로 Table을 생성
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Article {

    //대푯값이 있어야한다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1,2,3,,,, 자동생성
    private Long id;

    @Column
    private String title;
    @Column
    private String content;



}
