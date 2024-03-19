package com.dh.dental.clinic.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dentist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String enrollment;
    // Hay que crear la relacion @OnteToMany
    private Set<Appoinment> appoinmentSet = new HashSet<>();

}
