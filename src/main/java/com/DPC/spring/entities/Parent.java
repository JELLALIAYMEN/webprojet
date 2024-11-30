package com.DPC.spring.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;  // Remplacer Long par String pour MongoDB

    private String firstname;
    private String secondname;
    @OneToMany(mappedBy="Par")

    private List<Actualite> actualites;

}
