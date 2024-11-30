package com.DPC.spring.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MatiereDTO {
    private Long id;
    private String nom;
    private Double coefficient;

    private Long eleveId;


    // Getters et Setters



}
