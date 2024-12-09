package com.DPC.spring.entities;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Utilisateur {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nom ;
	private String prenom ;
	private String password ;
	private String login ;
	private String email ;
	private String profil ;
	private String libelle ;
	private Boolean archiver ;
	@JsonIgnore
	@Temporal(TemporalType.DATE)
	private Date datecreation ;
	@JsonIgnore
	@ManyToOne
	private Autority authorities;
	@ManyToOne
	Classe classe ;

	@ManyToOne
	private  Departement departement;


}
