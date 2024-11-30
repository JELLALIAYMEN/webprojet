package com.DPC.spring.DTO;

import lombok.Builder;

import com.DPC.spring.entities.Niveau;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClasseDTO {
    private String nomClasse;
    private Niveau niveau;
}
