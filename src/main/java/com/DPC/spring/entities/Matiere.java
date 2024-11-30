package com.DPC.spring.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "matiere")
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Assurez-vous que c'est bien une clé primaire

    private String nom;
    private Double coefficient;

    @ManyToOne
    @JoinColumn(name = "eleve_id", nullable = true) // Permet NULL dans eleve_id
    private Eleve eleve;


    @OneToMany(mappedBy = "mat")
    private List<Note> notes;


}
