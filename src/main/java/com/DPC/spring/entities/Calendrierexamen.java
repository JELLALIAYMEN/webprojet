package com.DPC.spring.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Calendrierexamen {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;
    private String nomjour ;
    private String periode ; 
    private String typecalendrier ; 
    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;
    
    @ManyToOne
    private Salle salle;
    @ManyToOne
    private Matiere matiere ; 
    @ManyToOne
    Utilisateur user ;
    


}
