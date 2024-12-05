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
    Utilisateur user ;
}
