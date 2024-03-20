package com.dh.dental.clinic.dto;

import com.dh.dental.clinic.entity.Address;
import com.dh.dental.clinic.entity.Appoinment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatientDTO {
    private String name;
    private String surname;
    private String dni;
    //private LocalDate registrationDate;
    private Address address;
    private Set<Appoinment> appoinmentList = new HashSet<>();
}
