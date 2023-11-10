package com.example.memberservice;

import com.example.memberservice.beans.EvenementBean;
import com.example.memberservice.beans.OutilBean;
import com.example.memberservice.beans.PublicationBean;
import com.example.memberservice.dao.MembreRepository;
import com.example.memberservice.entities.EnseignantChercheur;


import com.example.memberservice.entities.Etudiant;
import com.example.memberservice.entities.Membre;
import com.example.memberservice.proxies.PublicationProxyService;
import com.example.memberservice.service.IMemberService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.example.memberservice")
@EnableFeignClients
public class MemberServiceApplication implements CommandLineRunner {
    MembreRepository membreRepository;
    IMemberService iMemberService;
    PublicationProxyService publicationProxyService;
    public static void main(String[] args) {

        SpringApplication.run(MemberServiceApplication.class, args);
    }
        public void run(String... args) throws Exception{

            System.out.println("helllo");

            Etudiant etd1=Etudiant.builder()
                    .cin("123456")
                    .dateInscription(new Date())
                    .dateNaissance(new Date())
                    .diplome("mastère")
                    .email("etd1@gmail.com")
                    .password("pass1")
                    .encadrant(null)
                    .cv("cv1")
                    .nom("abid")
                    .prenom("youssef")
                    .sujet("blockhain")
                    .build();
            Etudiant etd2=Etudiant.builder()
                    .cin("1235556")
                    .dateInscription(new Date())
                    .dateNaissance(new Date())
                    .diplome("license")
                    .email("manar.labidi@gmail.com")
                    .password("root")
                    .encadrant(null)
                    .cv("cv1")
                    .nom("manar")
                    .prenom("labidi")
                    .sujet(".net")
                    .build();

            iMemberService.addMembre(etd1);
            iMemberService.addMembre(etd2);

            EnseignantChercheur enseignant1 = EnseignantChercheur.builder()
                    .cin("CIN1")
                    .nom("Nom1")
                    .prenom("Prenom1")
                    .date(new Date())
                    .cv("CV1")
                    .email("email1@example.com")
                    .password("password1")
                    .grade("Grade1")
                    .etablissement("Etablissement1")
                    .build();

            EnseignantChercheur enseignant2 = EnseignantChercheur.builder()
                    .cin("CIN2")
                    .nom("Nom2")
                    .prenom("Prenom2")
                    .date(new Date())
                    .cv("CV2")
                    .email("email2@example.com")
                    .password("password2")
                    .grade("Grade2")
                    .etablissement("Etablissement2")
                    .build();
            iMemberService.addMembre(enseignant1);
            iMemberService.addMembre(enseignant2);





            iMemberService.affecter_EtudiantToEnseigant(1L, 3L);
            iMemberService.affecter_EtudiantToEnseigant(2L, 3L);



            List<Etudiant> etudiants = iMemberService.findEtudiantByEncadrant(enseignant1);

            for (Etudiant etudiant : etudiants) {
                System.out.println(etudiant);
            }

            PublicationBean p =publicationProxyService.findPublicationById(1L);
            System.out.println("Publication" + p.getTitre());
            //affecter des publications à des auteurs
            iMemberService.affecterauteurTopublication(1L, 1L);
            iMemberService.affecterauteurTopublication(1L, 2L);
            iMemberService.affecterauteurTopublication(3L, 3L);
            iMemberService.affecterauteurToOutil(1L, 1L);
            iMemberService.affecterauteurToOutil(3L, 2L);
            iMemberService.affecterauteurToEvenement(1L, 1L);
            iMemberService.affecterauteurToEvenement(1L, 2L);

            List<PublicationBean> pubs = iMemberService.findPublicationparauteur(1L);
            List<OutilBean> outs = iMemberService.findOutilparauteur(1L);
            List<EvenementBean> evs = iMemberService.findEvenementparauteur(1L);
            Membre m1 = iMemberService.findMembre(1L);

            for (PublicationBean publication : pubs) {
                System.out.println("Membre: " + m1.getNom() + " had published   " + publication.getTitre());
            }
            for (OutilBean outil : outs) {
                System.out.println("Membre: " + m1.getNom() + " had used   " + outil.getSource()
                );
            }
            for (EvenementBean evenement : evs) {
                System.out.println("Membre: " + m1.getNom() + " participated in evenement  " + evenement.getTitre()
                );
            }







        }

    }

