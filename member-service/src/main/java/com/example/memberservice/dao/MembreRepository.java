package com.example.memberservice.dao;

import com.example.memberservice.entities.Membre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MembreRepository extends CrudRepository<Membre, Long> {
    Membre findByCin(String cin);

    List<Membre> findAll();

    Membre findByEmail(String email);
    Membre findByNom(String nom);
    Membre deleteMembreById(Long id);

    Membre saveAndFlush(Membre m);




}
