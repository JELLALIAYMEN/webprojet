package com.DPC.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DPC.spring.entities.Cours;

public interface CoursRepository extends JpaRepository<Cours, Long> {

}
