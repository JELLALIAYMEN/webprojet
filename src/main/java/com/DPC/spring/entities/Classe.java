package com.DPC.spring.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // For SQL database
    private Long id;

    private String nomclasse;

    // OneToMany relationship with Eleve (mapped by 'classe' field in Eleve entity)
    @OneToMany(mappedBy = "classe")
    private List<Eleve> eleveList;

    // ManyToOne relationship with Professeur
    @ManyToOne
    @JoinColumn(name = "professeur_id")  // Defines the foreign key column in Classe table
    private Professeur professeur;  // Corrected field name to 'professeur'
    @ManyToOne
    private Departement departement;

    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
    private List<Cours> cours = new ArrayList<>();
    // ManyToOne relationship with Admin
    @ManyToOne
    @JoinColumn(name = "admin_id")  // Define the foreign key column for Admin
    private Admin adm;
}