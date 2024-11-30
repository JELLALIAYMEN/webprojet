package com.DPC.spring.services;

import org.springframework.http.ResponseEntity;

import com.DPC.spring.DTO.MoyenneDTO;
import com.DPC.spring.DTO.NoteDTO;
import com.DPC.spring.entities.Trimestre;

import java.util.List;

public interface Moyenneservice {
    public abstract MoyenneDTO saveMoyenne(MoyenneDTO moyenneDTO);



    List<NoteDTO> findByidmatiereAndidel(Long idmatiere);


    public Double calculerMoyenneAnnuelle(Long elId);


   // Double calculerMoyenneParEleveEtTrimestre(Long elId, Trimestre trimestre);

    Double calculerMoyenneParMatiéreAndEleve(Long elId, Trimestre trimestre, Long idMatiere);

    Double calculerEtEnregistrerMoyenneTrimestrielle(Long elId, Trimestre trimestre);

    public Double updateMoyenne(Double moyennevalue, Long idmoy);

}
