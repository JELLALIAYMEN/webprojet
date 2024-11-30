package com.DPC.spring.entities;

import java.util.List;

import javax.persistence.*;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Professeur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // For SQL database
    private Long id;
    private String libelle ;
    private String nom;
    private String prenom;

    // OneToMany relationship with Classe (One professor can teach many classes)
    @OneToMany(mappedBy = "professeur")  // Professors can teach many classes
    private List<Classe> classes;
}