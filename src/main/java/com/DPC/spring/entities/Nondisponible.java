package com.DPC.spring.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Nondisponible {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String nomjour ;
@ManyToOne
private Professeur prof ; 
}
