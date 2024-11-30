package com.DPC.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DPC.spring.entities.Eleve;

public interface Eleverep extends JpaRepository<Eleve, Long> {
	Eleve findByCode(String code);

}
