package com.dh.dental.clinic.dto;

import com.dh.dental.clinic.entity.Address;
import com.dh.dental.clinic.entity.Appointment;
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
