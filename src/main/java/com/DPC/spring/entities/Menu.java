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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeMenu getTypemenu() {
		return Typemenu;
	}

	public void setTypemenu(TypeMenu typemenu) {
		Typemenu = typemenu;
	}

	public String getPlatentree() {
		return platentree;
	}

	public void setPlatentree(String platentree) {
		this.platentree = platentree;
	}

	public String getPlatprincipale() {
		return platprincipale;
	}

	public void setPlatprincipale(String platprincipale) {
		this.platprincipale = platprincipale;
	}

	public String getDessert() {
		return dessert;
	}

	public void setDessert(String dessert) {
		this.dessert = dessert;
	}

	public String getNomjour() {
		return nomjour;
	}

	public void setNomjour(String nomjour) {
		this.nomjour = nomjour;
	}

	public LocalDate getDatedeb() {
		return datedeb;
	}

	public void setDatedeb(LocalDate datedeb) {
		this.datedeb = datedeb;
	}

	public LocalDate getDatefin() {
		return datefin;
	}

	public void setDatefin(LocalDate datefin) {
		this.datefin = datefin;
	}
}
