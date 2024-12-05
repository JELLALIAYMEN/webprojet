package com.DPC.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DPC.spring.entities.Nondisponible;
import com.DPC.spring.entities.Utilisateur;

public interface NomdispoRepository extends JpaRepository<Nondisponible,Long> {


	Nondisponible findByNomjourAndUser(String nomjour, Utilisateur p);

}
