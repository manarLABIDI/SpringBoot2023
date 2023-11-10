package com.example.memberservice.service;


import com.example.memberservice.beans.EvenementBean;
import com.example.memberservice.beans.OutilBean;
import com.example.memberservice.beans.PublicationBean;
import com.example.memberservice.entities.EnseignantChercheur;
import com.example.memberservice.entities.Etudiant;
import com.example.memberservice.entities.Membre;

import java.util.List;


public interface IMemberService {
    public Membre addMembre(Membre m);

    public void deleteMembre(Long id);
    public Membre updateMembre(Membre membre);

    public Membre findMembre(Long id);

    public List<Membre>  findAll();
    public Membre findByNom(String nom);


    //recherche spécifique des étudiants
    public List<Etudiant> findByDiplome(String diplome);
    public List<EnseignantChercheur> findByGrade(String grade);


    public void affecter_EtudiantToEnseigant(Long idEtudiant, Long idEnseignant);

    public List<Etudiant>  findEtudiantByEncadrant(EnseignantChercheur enseignantChercheur);

    public void affecterauteurTopublication(Long idauteur, Long idpub);
    public List<PublicationBean> findPublicationparauteur(Long idauteur);

    public void affecterauteurToOutil(Long idauteur, Long idoutil);
    public List<OutilBean> findOutilparauteur(Long idauteur);
    public void affecterauteurToEvenement(Long idauteur, Long idEv);
    public List<EvenementBean> findEvenementparauteur(Long idauteur);
}
