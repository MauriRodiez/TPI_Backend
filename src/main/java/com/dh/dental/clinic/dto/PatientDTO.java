package com.dh.dental.clinic.dto;

import lombok.*;

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
    private AddressDTO addressDTO;
    private Set<AppointmentDTO> appointmentDTOList = new HashSet<>();
}
