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
@Entity
public class Reclamation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;  
    private String code;

    @Temporal(TemporalType.DATE) 
    private Date date;

    private String sujet;  
    private String resultat; 

    @ManyToOne
    Utilisateur user ;
    
}