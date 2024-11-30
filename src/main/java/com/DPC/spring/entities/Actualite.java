package com.DPC.spring.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
// Ignorer des propriétés lors de la sérialisation
public class Actualite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID est un Long pour une base de données relationnelle

    private String sujet; // Sujet de l'actualité

    @Temporal(TemporalType.DATE)
    private Date date; // Date de l'actualité

    @ManyToOne
    @JoinColumn(name = "eleve_id") // Spécifie la colonne de jointure pour l'élève
    private Eleve el; // Association avec l'entité Eleve

    @ManyToOne
    @JoinColumn(name = "parent_id") // Spécifie la colonne de jointure pour le parent
    private Parent Par; // Association avec l'entité Parent

    @ManyToOne
    @JoinColumn(name = "admin_id") // Spécifie la colonne de jointure pour l'admin
    private Admin adm; // Association avec l'entité Admin
}
