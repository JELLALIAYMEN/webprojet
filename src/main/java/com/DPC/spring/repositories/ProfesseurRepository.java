package com.DPC.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DPC.spring.entities.Professeur;

public interface ProfesseurRepository  extends JpaRepository<Professeur,Long>{

	Professeur findByLibelle(String libelle);

}
