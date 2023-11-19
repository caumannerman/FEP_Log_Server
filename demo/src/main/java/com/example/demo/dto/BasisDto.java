package com.example.demo.dto;

import com.example.demo.entity.Basis;

import lombok.AllArgsConstructor;
import lombok.ToString;



@AllArgsConstructor
@ToString
public class BasisDto {

    private String time;
    private String date;
    private String mbasis;
    private String bbasis;


    //dto 객체를 db에 맵핑할 수 있게 Entity로 바꿔줌
    public Basis toEntity(){
        return new Basis(null,time, date, mbasis, bbasis);
    }
}