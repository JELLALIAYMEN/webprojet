package com.DPC.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DPC.spring.entities.Note;
import com.DPC.spring.entities.Trimestre;
import com.DPC.spring.entities.Utilisateur;

public interface Noterep extends JpaRepository<Note, Long> {

	List<Note> findByUserAndTrimestreAndMat_Id(Utilisateur elId, Trimestre trimestre, Long idMatiere);

}
