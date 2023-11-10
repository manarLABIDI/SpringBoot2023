package com.example.memberservice.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Membre_Publication {

    @EmbeddedId
    private Membre_Pub_Id id;
    @ManyToOne
    @MapsId("auteur_id")
    private Membre auteur;



}
