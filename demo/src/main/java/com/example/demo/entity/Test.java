package com.example.demo.entity;

import lombok.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long test_id;

    @Column(name="t",nullable = false)
    private  String textText;
}