package com.dh.dental.clinic.dto.entityDTO.impl;

import com.dh.dental.clinic.dto.entityDTO.EntityIdentificatorDTO;
import com.dh.dental.clinic.entity.Dentist;
import com.dh.dental.clinic.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO implements EntityIdentificatorDTO {
    private Long id;
    private LocalDateTime dateAppoinment;
    private Patient patient;
    private Dentist dentist;

}
