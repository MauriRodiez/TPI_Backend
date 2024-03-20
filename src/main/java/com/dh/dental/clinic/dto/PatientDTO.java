package com.dh.dental.clinic.dto;

import com.dh.dental.clinic.entity.Address;
import com.dh.dental.clinic.entity.Appoinment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
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
    private Address address;
    private String dni;
    private Date registrationDate;
    private Set<Appoinment> appoinmentList = new HashSet<>();
}
