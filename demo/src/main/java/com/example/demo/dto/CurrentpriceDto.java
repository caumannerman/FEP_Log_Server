package com.example.demo.dto;

import com.example.demo.entity.Currentprice;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;

@AllArgsConstructor
@ToString
public class CurrentpriceDto {

    private String issuecode;
    private String date;
    private String time;
    private String price;

    //dto 객체를 db에 맵핑할 수 있게 Entity로 바꿔줌
    public Currentprice toEntity(){
        return new Currentprice(null,issuecode,date, time,price);
    }
}