package com.example.demo.dto;


import com.example.demo.entity.Futuresquantity;
import lombok.AllArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@ToString
public class FuturesquantityDto {

    private String time;
    private String date;
    private String quantity;


    //dto 객체를 db에 맵핑할 수 있게 Entity로 바꿔줌
    public Futuresquantity toEntity(){
        return new Futuresquantity(null,time, date, quantity);
    }
}