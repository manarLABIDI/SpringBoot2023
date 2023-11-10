package com.example.memberservice.beans;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class PublicationBean {


    private Long id;

    private String titre;
    private String type;


    private Date dateApparition;

    private String lien;

    private String sourcePdf;

}
