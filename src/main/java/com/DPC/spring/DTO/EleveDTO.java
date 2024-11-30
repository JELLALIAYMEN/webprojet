package com.DPC.spring.DTO;

import java.util.ArrayList;
import java.util.List;

import com.DPC.spring.entities.Niveau;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EleveDTO {
    private Long id;  // Changement de Long à String pour MongoDB
    private String code;
    private String firstname;
    private String secondname;

    private String addrese;
    private String gmail;
    private String photo;

    private Niveau niveau;


}
