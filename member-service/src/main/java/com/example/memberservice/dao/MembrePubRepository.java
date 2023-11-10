package com.example.memberservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import com.example.memberservice.entities.Membre_Publication;
import com.example.memberservice.entities.Membre_Pub_Id;
import com.example.memberservice.entities.Membre;

import java.util.List;


public interface MembrePubRepository extends JpaRepository<Membre_Publication, Membre_Pub_Id> {
        List<Membre_Publication> findByAuteur(Membre auteur);

}
