package com.example.memberservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("etd")
public class Etudiant extends Membre {

    @Temporal(TemporalType.DATE)
    private Date dateInscription;
    private String diplome;
    private String sujet;

    @JsonIgnore
    @ManyToOne
    @ToString.Exclude
    private EnseignantChercheur encadrant;

    @Builder
    public Etudiant( String cin, String nom, String prenom, Date dateNaissance,
                     String cv,String email, String password, Date dateInscription, String sujet, String diplome,
                     EnseignantChercheur encadrant) {
        super( cin, nom, prenom, dateNaissance, cv, email, password);
        this.dateInscription = dateInscription;
        this.sujet = sujet;
        this.diplome = diplome;
        this.encadrant = encadrant;
    }


}