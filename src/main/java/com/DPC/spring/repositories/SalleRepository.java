package com.DPC.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DPC.spring.entities.Salle;

public interface SalleRepository extends JpaRepository<Salle, Long> {


	Salle findByNomdesalle(String nomdesalle);

}
