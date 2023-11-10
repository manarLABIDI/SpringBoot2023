package com.example.memberservice.dao;

import com.example.memberservice.entities.Membre;
import com.example.memberservice.entities.Membre_Eve_Id;
import com.example.memberservice.entities.Membre_Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembreEvRepository extends JpaRepository<Membre_Evenement, Membre_Eve_Id> {
    List<Membre_Evenement> findByAuteur(Membre auteur);
}
