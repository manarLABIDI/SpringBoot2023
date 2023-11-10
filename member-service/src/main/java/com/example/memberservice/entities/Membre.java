package com.example.memberservice.entities;

import com.example.memberservice.beans.EvenementBean;
import com.example.memberservice.beans.OutilBean;
import com.example.memberservice.beans.PublicationBean;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "type_mbr", discriminatorType =
        DiscriminatorType.STRING,length = 3)
public abstract class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String cin;
    @NonNull
    private String nom;
    @NonNull
    private String prenom;
    @NonNull @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private byte[] photo;
    @NonNull
    private String cv;
    @NonNull
    private String email;
    @NonNull
    private String password;

    @Transient
    Collection<PublicationBean> pubs;

    @Transient
    Collection<OutilBean> outils;
    @Transient
    Collection<EvenementBean> evs;







}
