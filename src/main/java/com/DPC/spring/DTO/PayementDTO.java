package com.DPC.spring.DTO;

import java.time.LocalDate;

import com.DPC.spring.entities.Modepay;
import com.DPC.spring.entities.Statuspay;
import com.DPC.spring.entities.Typepay;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class PayementDTO {
    private double amount;
    private LocalDate date;

    @JsonProperty("typepay")
    private Typepay typepay;

    @JsonProperty("modepay")
    private Modepay modepay;

    private Statuspay statusPay;

    private String file;
    private String filePath;
    private String code;
   // Correction ici, pour utiliser EleveDTO au lieu de Eleve
}

