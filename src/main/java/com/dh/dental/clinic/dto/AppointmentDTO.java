package com.dh.dental.clinic.dto;

import com.dh.dental.clinic.entity.Dentist;
import com.dh.dental.clinic.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO implements EntityIdentificatorDTO {
    private Long id;
    private LocalDateTime dateAppoinment;
    private PatientDTO patientDTO;
    private DentistDTO dentistDTO;
}
