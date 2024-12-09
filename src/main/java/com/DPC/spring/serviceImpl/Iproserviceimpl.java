package com.DPC.spring.serviceImpl;

import com.DPC.spring.entities.Departement;
import com.DPC.spring.entities.Professeur;
import com.DPC.spring.entities.Utilisateur;
import com.DPC.spring.repositories.DepartementRepository;
import com.DPC.spring.repositories.Proffesseurrep;
import com.DPC.spring.repositories.UtilisateurRepository;
import com.DPC.spring.services.Iproservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Iproserviceimpl implements Iproservice {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    DepartementRepository departementRepository;

    @Autowired
    Proffesseurrep proffesseurrep;




}