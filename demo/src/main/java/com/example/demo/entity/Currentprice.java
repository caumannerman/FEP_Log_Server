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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String issuecode;

    @Column
    private String date;

    @Column
    private String time;

    @Column
    private String price;


}
