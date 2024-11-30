package com.DPC.spring.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Vous pouvez ajuster la stratégie selon votre besoin
    private Long id; // Si vous souhaitez un identifiant de type Long

    private String firstname;
    private String secondname;

    @OneToMany(mappedBy="adm")
    private List<Actualite> actualites; // Références aux Actualites

    @OneToMany(mappedBy="adm")
    private List<Classe> classes; // Références aux Classes
}