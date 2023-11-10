package com.example.memberservice.dao;

import com.example.memberservice.entities.EnseignantChercheur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EnseignantChercheurRepository extends CrudRepository<EnseignantChercheur, Long> {
    List<EnseignantChercheur> findByGrade(String grade);
    List<EnseignantChercheur> findByEtablissement(String etablissement);

}
