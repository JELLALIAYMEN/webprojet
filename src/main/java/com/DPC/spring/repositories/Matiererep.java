package com.DPC.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DPC.spring.entities.Matiere;

public interface Matiererep extends JpaRepository<Matiere, Long> {

	Matiere findByNom(String matiere);

}
