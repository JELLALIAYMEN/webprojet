package com.DPC.spring.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "menu")
public class Menu {
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id; 
	  	@Enumerated(EnumType.STRING)
	    private TypeMenu Typemenu;
	  	private String platentree ;
	  	private String platprincipale ; 
	  	private String dessert ;
	  	private String nomjour ; 
	  	 private LocalDate datedeb;
	     private LocalDate datefin;
}
