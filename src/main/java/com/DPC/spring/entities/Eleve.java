package com.DPC.spring.entities;

import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor // Keep this annotation for a no-args constructor
@Entity
public class Eleve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "el_code")
    private String code;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    private String firstname;
    private String secondname;
    private String addrese;
    private String gmail;
    private String photo;

    // Relations avec d'autres documents
    @OneToMany(mappedBy = "eleve")
    private List<Payement> payements;

    @OneToMany(mappedBy = "el", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Moyenne> moyennes;

    @OneToMany(mappedBy="el")
    private List<Discipline> disciplines;


    @OneToMany(mappedBy = "el")
    private List<Reclamation> reclamations;

    @OneToMany(mappedBy= "el")
    private List<Actualite> actualites;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;



    @OneToMany(mappedBy="el", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes;  // Un élève peut avoir plusieurs notes
    // Custom method to initialize fields, including UUID
    @PostConstruct
    public void init() {
        this.code = UUID.randomUUID().toString(); // Generate a unique code for each student
    }
}