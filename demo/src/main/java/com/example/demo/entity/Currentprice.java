package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(Currentpriceid.class)
public class Currentprice {

    @Id
    private String issuecode;

    @Id
    private String date;

    @Id
    private String time;

    @Column
    private String price;


}
