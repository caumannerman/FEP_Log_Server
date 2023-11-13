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
    private String sissuecode;
    @Id
    private String date;
    @Column
    private String sbookcode;
    @Column
    private int quantity;
    @Column
    private Double avgprice;

}