package com.example.memberservice.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Membre_Evenement {

    @EmbeddedId
    private Membre_Eve_Id  id;
    @ManyToOne
    @MapsId("auteur_id")
    private Membre auteur;
}
