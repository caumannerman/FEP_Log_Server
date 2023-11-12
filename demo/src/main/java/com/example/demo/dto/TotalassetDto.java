package com.example.demo.dto;

import com.example.demo.entity.Totalasset;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class TotalassetDto {

    private String sbookcode;
    private String date;
    private int buyquantity;
    private Long buytotalprice;
    private int sellquantity;
    private Long selltotalprice;


    //dto 객체를 db에 맵핑할 수 있게 Entity로 바꿔줌
    public Totalasset toEntity(){
        return new Totalasset(sbookcode,date, buyquantity,buytotalprice,sellquantity,selltotalprice);
    }
}