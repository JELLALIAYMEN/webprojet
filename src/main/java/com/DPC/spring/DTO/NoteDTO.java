package com.DPC.spring.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import com.DPC.spring.entities.Trimestre;
import com.DPC.spring.entities.TypeNote;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO {
    private Long id;

    @NotNull(message = "idmatiere must not be null")
    private Long idmatiere;

    @NotNull(message = "idel must not be null")
    private Long idel;

    @NotNull(message = "typeNote must not be null")
    private TypeNote typeNote;

    @NotNull(message = "noteValue must not be null")
    private Double noteValue;

    @NotNull(message = "trimestre must not be null")
    private Trimestre trimestre;
    @Column(nullable = true)
    private Double coff;


}
