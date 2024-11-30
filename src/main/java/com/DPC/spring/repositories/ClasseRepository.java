package com.DPC.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DPC.spring.entities.Classe;

public interface ClasseRepository extends JpaRepository<Classe,Long> {

	Classe findByNomclasse(String classe);

}
