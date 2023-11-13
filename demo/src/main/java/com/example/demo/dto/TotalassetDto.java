package com.example.demo.dto;

import com.example.demo.entity.Totalasset;
import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;

@AllArgsConstructor
@ToString
public class TotalassetDto {

    private String sissuecode;
    private String date;
    private String sbookcode;
    private int quantity;
    private Long pricesum;
    private Long realprofit;

    //dto 객체를 db에 맵핑할 수 있게 Entity로 바꿔줌
    public Totalasset toEntity(){
        return new Totalasset(sissuecode,date, sbookcode,quantity,pricesum, realprofit);
    }
}