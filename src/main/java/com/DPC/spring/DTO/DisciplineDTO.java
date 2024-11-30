package com.DPC.spring.DTO;

import javax.validation.constraints.NotNull;

import com.DPC.spring.entities.TypeDisc;

import lombok.Data;

@Data
public class DisciplineDTO {
    private Long idd;
    @NotNull(message = "idel must not be null")
    private Long idel;
    private TypeDisc typeDisc;

}

