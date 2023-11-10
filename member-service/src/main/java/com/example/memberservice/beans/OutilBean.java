package com.example.memberservice.beans;


import lombok.Data;

import java.time.LocalDateTime;

@Data

public class OutilBean {

    private Long id;


    private LocalDateTime date;


    private String source;
}
