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
public class Basis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String date;

    @Column
    private String time;
    @Column
    private String mbasis;

    @Column
    private String bbasis;

}
