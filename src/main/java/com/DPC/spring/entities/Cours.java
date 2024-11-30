package com.DPC.spring.entities;

import javax.persistence.*;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String horaire;

    @ManyToOne
    private Classe classe;

    @ManyToOne
    private Salle salle; // Salle attribuée
}