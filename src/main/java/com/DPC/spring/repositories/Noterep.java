package com.DPC.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DPC.spring.entities.Note;
import com.DPC.spring.entities.Trimestre;

public interface Noterep extends JpaRepository<Note, Long> {

	List<Note> findByEl_IdAndTrimestreAndMat_Id(Long elId, Trimestre trimestre, Long idMatiere);

}
