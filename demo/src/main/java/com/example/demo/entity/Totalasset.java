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
@IdClass(Totalassetid.class)
public class Totalasset {
    @Id
    private String sbookcode;
    @Id
    private String date;
    @Column
    private int buyquantity;
    @Column
    private Long buytotalprice;
    @Column
    private int sellquantity;
    @Column
    private Long selltotalprice;
}