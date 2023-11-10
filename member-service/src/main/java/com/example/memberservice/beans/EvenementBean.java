package com.example.memberservice.beans;


import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
public class EvenementBean {

    private Long id;


    private String titre;

    private LocalDateTime date;

    private String lieu;
}
