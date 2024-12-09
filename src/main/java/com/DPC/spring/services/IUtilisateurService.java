package com.DPC.spring.services;

import com.DPC.spring.entities.TypeMenu;
import com.DPC.spring.entities.Utilisateur;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IUtilisateurService {

   // void  add(Utilisateur utilisateur);

    List<Utilisateur> GetUtilisateur();

    List<Utilisateur> findAllByProfil(String profil);

    List<Utilisateur> affecterUtilisateurDepartement(Long id, String email);

    //Utilisateur ajoutermenu(String platentree, String platprincipale, String dessert, String nomjour, LocalDate datedeb, LocalDate datefin, TypeMenu Typemenu);

  //  Utilisateur ajouterMenu(String platentree, String platprincipale, String dessert, String nomjour, LocalDate datedeb, LocalDate datefin, TypeMenu typemenu);

    Utilisateur affecterUtilisateurClasse(String email, Long id);



    //String affecterUtilisateurdepartement(Long id, String email, String profil);

    //Utilisateur updateUtilisateur(Utilisateur user, Long id);
}
