package com.example.memberservice.entities;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Membre_Outi_Id implements Serializable{
    private Long outil_id;
    private Long auteur_id;
}
