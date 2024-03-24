package com.dh.dental.clinic.dto.entityDTO.impl;

import com.dh.dental.clinic.dto.entityDTO.EntityIdentificatorDTO;
import com.dh.dental.clinic.entity.Address;
import com.dh.dental.clinic.entity.Appointment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientDTO implements EntityIdentificatorDTO {
    private Long id;
    private String name;
    private String surname;
    private String dni;
    private LocalDate registrationDate;
    private Address address;
    private Set<Appointment> appoinmentList = new HashSet<>();
}
