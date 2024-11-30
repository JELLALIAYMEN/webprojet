package com.DPC.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DPC.spring.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement,Long> {

	Departement findByNom(String nomdepartement);

}
