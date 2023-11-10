package com.example.memberservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("ens")
public class EnseignantChercheur extends Membre {

    private String grade;
    private String etablissement;

    @JsonIgnore
    @OneToMany(mappedBy= "encadrant", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Etudiant> etds;

    @Builder
    public EnseignantChercheur(@NonNull String cin, @NonNull String nom, @NonNull String prenom, @NonNull Date date,
                               @NonNull String cv, @NonNull String email, @NonNull String password, String grade, String etablissement) {
        super(cin, nom, prenom, date, cv, email, password);
        this.grade = grade;
        this.etablissement = etablissement;
    }


}