package com.example.memberservice.controller;

import com.example.memberservice.entities.EnseignantChercheur;
import com.example.memberservice.entities.Etudiant;
import com.example.memberservice.entities.Membre;
import com.example.memberservice.service.IMemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
//@RequestMapping("/membres")
public class MemberRestController {

    private final IMemberService memberService;

    @GetMapping("/membres")
    public List<Membre> findMembres() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public Membre findOneMemberById(@PathVariable Long id) {
        return memberService.findMembre(id);
    }

    @GetMapping("/nom")
    public Membre findOneMemberByNom(@RequestParam String nom) {
        return memberService.findByNom(nom);
    }

    ///POST
    @PostMapping("/enseignant")
    public Membre addMembre(@RequestBody EnseignantChercheur m)
    {
        return memberService.addMembre(m);
    }
    @PostMapping("/etudiant")
    public Membre addMembre(@RequestBody Etudiant e)
    {
        return memberService.addMembre(e);
    }

    @DeleteMapping(value="/{id}")
    public void deleteMembre(@PathVariable Long id) {
        memberService.deleteMembre(id);
    }


    @PutMapping(value="/etudiant/{id}")
    public Membre updatemembre(@PathVariable Long id, @RequestBody
    Etudiant p)
    {
        p.setId(id);
        return memberService.updateMembre(p);
    }
    @PutMapping(value="/enseignant/{id}")
    public Membre updateMembre(@PathVariable Long id, @RequestBody
    EnseignantChercheur p)
    {
        p.setId(id);
        return memberService.updateMembre(p);
    }
    @GetMapping("/fullmember/{id}")
    public Membre findAFullMember(@PathVariable(name="id") Long id)
    {
        Membre mbr=memberService.findMembre(id);
        mbr.setPubs(memberService.findPublicationparauteur(id));
        mbr.setOutils(memberService.findOutilparauteur(id));
        mbr.setEvs(memberService.findEvenementparauteur(id));
        return mbr;
    }


}
