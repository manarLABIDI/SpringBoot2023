package com.example.memberservice.service;

import com.example.memberservice.beans.EvenementBean;
import com.example.memberservice.beans.OutilBean;
import com.example.memberservice.beans.PublicationBean;
import com.example.memberservice.dao.*;
import com.example.memberservice.entities.*;
import com.example.memberservice.proxies.EvenementProxyService;
import com.example.memberservice.proxies.OutilProxyService;
import com.example.memberservice.proxies.PublicationProxyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class MemberImpl implements IMemberService{

   MembreRepository membreRepository;
   EnseignantChercheurRepository enseignantChercheurRepository;
   EtudiantRepository etudiantRepository;
   MembrePubRepository membrePubRepository;
   MembreOutilRepository membreOutilRepository;
   MembreEvRepository membreEvRepository;
   EvenementProxyService evenementProxyService;
   PublicationProxyService publicationProxyService;
   OutilProxyService outilProxyService;

   public Membre addMembre(Membre m){
       membreRepository.save(m);
       return m;

    }
    public Membre findByNom(String nom){
       Membre m = membreRepository.findByNom(nom);
       return m;
    }
    public Membre findMembre(Long id) {
        Membre m= (Membre)membreRepository.findById(id).get();
        return m;
    }
    public Membre updateMembre(Membre m) {

       return membreRepository.saveAndFlush(m);
    }


    public void deleteMembre(Long id) {
       membreRepository.deleteMembreById(id);

    }

    @Override
    public List<Membre> findAll() {
        return membreRepository.findAll()  ;
    }

    public List<EnseignantChercheur> findByGrade(String grade){
       return enseignantChercheurRepository.findByGrade(grade);
    }

    public List<Etudiant> findByDiplome(String diplome){

        return etudiantRepository.findByDiplome(diplome);

    }
    public void affecter_EtudiantToEnseigant(Long idEtudiant, Long idEnseignant){

       Etudiant etd = (Etudiant) membreRepository.findById(idEtudiant).get();
       EnseignantChercheur ens = (EnseignantChercheur) membreRepository.findById(idEnseignant).get();
       etd.setEncadrant(ens);
       membreRepository.save(etd);

    }
    public void affecterauteurTopublication(Long idauteur, Long idpub){
        Membre mbr= membreRepository.findById(idauteur).get();
        Membre_Publication mbs= new Membre_Publication();
        mbs.setAuteur(mbr);
        mbs.setId(new Membre_Pub_Id(idpub, idauteur));
        membrePubRepository.save(mbs);
    }
    public List<PublicationBean> findPublicationparauteur(Long idauteur) {
        List<PublicationBean> pubs=new ArrayList<PublicationBean>();
        Membre auteur= membreRepository.findById(idauteur).get();
        List< Membre_Publication>
                idpubs= membrePubRepository.findByAuteur(auteur);
        idpubs.forEach(s->{
                   System.out.println(s);
                    pubs.add(publicationProxyService.findPublicationById(s.getId().getPublication_id()));
                }
        );
        return pubs;
    }
    /*public List<Etudiant> findEtudiantByEncadrant(EnseignantChercheur enseignantChercheur){
        return  membreRepository.findEtudiantByEncadrant(enseignantChercheur);}*/

    public List<Etudiant> findEtudiantByEncadrant(EnseignantChercheur ens) {
        List<Etudiant> etds = new ArrayList<>();
        List<Membre> members = membreRepository.findAll();

        for (Membre member : members) {
            if (member instanceof Etudiant) {
                Etudiant student = (Etudiant) member;
                if (student.getEncadrant() != null && student.getEncadrant().equals(ens)) {
                    etds.add(student);
                }
            }
        }
        return etds;
    }
    public void affecterauteurToOutil(Long idauteur, Long idoutil){
        Membre mbr= membreRepository.findById(idauteur).get();
        Membre_Outil mbo = new Membre_Outil();
        mbo.setAuteur(mbr);
        mbo.setId(new Membre_Outi_Id(idoutil, idauteur));
        membreOutilRepository.save(mbo);
    }
    public List<OutilBean> findOutilparauteur(Long idauteur){
        List<OutilBean> outils = new ArrayList<OutilBean>();
        Membre auteur= membreRepository.findById(idauteur).get();
        List< Membre_Outil>
                idoutils= membreOutilRepository.findByAuteur(auteur);
        idoutils.forEach(s->{
                    System.out.println(s);
            outils.add(outilProxyService.findOutilById(s.getId().getOutil_id()));
                }
        );
        return outils;
    }

    public void affecterauteurToEvenement(Long idauteur, Long idEv){
        Membre mbr= membreRepository.findById(idauteur).get();
        Membre_Evenement mbe = new Membre_Evenement();
        mbe.setAuteur(mbr);
        mbe.setId(new Membre_Eve_Id(idEv, idauteur));
        membreEvRepository.save(mbe);
    }
    public List<EvenementBean> findEvenementparauteur(Long idauteur){
        List<EvenementBean> evs = new ArrayList<EvenementBean>();
        Membre auteur= membreRepository.findById(idauteur).get();
        List< Membre_Evenement> idEvs= membreEvRepository.findByAuteur(auteur);
        idEvs.forEach(s->{
                    System.out.println(s);
                    evs.add(evenementProxyService.findEvenementById(s.getId().getEvenement_id()));
                }
        );
        return evs;
    }


}







