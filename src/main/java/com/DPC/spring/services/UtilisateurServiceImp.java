package com.DPC.spring.services;


import com.DPC.spring.entities.Classe;
import com.DPC.spring.entities.Departement;
import com.DPC.spring.entities.TypeMenu;
import com.DPC.spring.entities.Utilisateur;
import com.DPC.spring.repositories.ClasseRepository;
import com.DPC.spring.repositories.DepartementRepository;
import com.DPC.spring.repositories.MenuRepository;
import com.DPC.spring.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

@Service
public class UtilisateurServiceImp implements  IUtilisateurService {


    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private DepartementRepository departementRepository;
    @Autowired
    ClasseRepository classeRepository;
    @Autowired
    MenuRepository menuRepository;


    @Override
    public List<Utilisateur> GetUtilisateur() {
        List<Utilisateur> utilisateur = (List<Utilisateur>) utilisateurRepository.findByArchiverIsFalse();
        return utilisateur;

    }

    @Override
    public List<Utilisateur> findAllByProfil(String profil) {
        return utilisateurRepository.findAllByProfil(profil);
    }


    @Override
    public List<Utilisateur> affecterUtilisateurDepartement(Long id, String email) {
        // Étape 1 : Récupérer tous les utilisateurs ayant le profil "Teach"
        List<Utilisateur> utilisateurs = utilisateurRepository.findAllByProfil("Teacher");

        // Étape 2 : Vérifier si des utilisateurs ont ce profil
        if (utilisateurs.isEmpty()) {
            throw new RuntimeException("Aucun utilisateur trouvé avec le profil Teach.");
        }

        // Étape 3 : Récupérer le département correspondant à l'id
        Departement departement = departementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Département non trouvé pour l'ID : " + id));

        // Étape 4 : Affecter le département aux utilisateurs
        for (Utilisateur utilisateur : utilisateurs) {
            // Si l'email correspond à celui passé en paramètre, affecter cet utilisateur au département
            if (utilisateur.getEmail().equals(email)) {
                utilisateur.setDepartement(departement);
                utilisateurRepository.save(utilisateur); // Sauvegarder l'utilisateur avec son nouveau département
            }
        }

        return utilisateurs; // Retourner la liste des utilisateurs affectés
    }
    @Override
    public Utilisateur affecterUtilisateurClasse(String email, Long id) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur != null) {
            Classe classe = classeRepository.findById(id).orElse(null);
            utilisateur.setClasse(classe);
            return utilisateurRepository.save(utilisateur);
        }
        return null;
    }
}











