package com.DPC.spring.DTO;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.DPC.spring.entities.MoyenneType;
import com.DPC.spring.entities.Trimestre;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MoyenneDTO {
  private String idmoy; // Identifiant de la moyenne
  private Double moyennevalue;
    @NotNull(message = "idel must not be null")
    private Long idel;
    @Enumerated(EnumType.STRING)
  private Trimestre trimestre; // Période associée à la moyenne
  @Enumerated(EnumType.STRING)
 private MoyenneType moyenneType;



}


