package com.DPC.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DPC.spring.entities.Nondisponible;
import com.DPC.spring.entities.Professeur;

public interface NomdispoRepository extends JpaRepository<Nondisponible,Long> {


	Nondisponible findByNomjourAndProf(String nomjour, Professeur p);

}
