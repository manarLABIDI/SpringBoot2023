package com.example.memberservice.dao;


import com.example.memberservice.entities.Membre;
import com.example.memberservice.entities.Membre_Outi_Id;
import com.example.memberservice.entities.Membre_Outil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembreOutilRepository extends JpaRepository<Membre_Outil, Membre_Outi_Id> {
    List<Membre_Outil> findByAuteur(Membre auteur);
}
