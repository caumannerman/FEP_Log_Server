package com.example.demo.entity;


import lombok.NoArgsConstructor;

        import java.io.Serializable;

        import lombok.AllArgsConstructor;
        import lombok.Data;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Totalassetid implements Serializable {
    private String sbookcode;
    private String date;
}
