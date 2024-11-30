package com.DPC.spring.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;  // Ensure this is Long and not String for JPA

    @Enumerated(EnumType.STRING)
    private TypeDisc typeDisc;

    @ManyToOne
    @JoinColumn(name = "eleve_id", nullable = false)

    private Eleve el;  // Ensure Eleve is correctly annotated as an entity as well
}
