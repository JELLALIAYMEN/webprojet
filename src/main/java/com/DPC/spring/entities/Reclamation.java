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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
@Entity // JPA annotation for SQL databases
public class Reclamation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // SQL ID generation
    private Long id;  // Keep this as Long for SQL auto-generated IDs

    private String code;

    @Temporal(TemporalType.DATE) // Correct way to handle dates in SQL databases
    private Date date;

    private String sujet;  // Subject of the complaint
    private String resultat;  // Details of the complaint

    @ManyToOne
    @JoinColumn(name = "eleve_id") // Specify foreign key column
    private Eleve el;  // Relationship to Eleve entity
}