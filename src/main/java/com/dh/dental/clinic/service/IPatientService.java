package com.dh.dental.clinic.service;

import com.dh.dental.clinic.dto.PatientDTO;
import com.dh.dental.clinic.entity.Patient;

import java.util.List;

public interface IPatientService {
    PatientDTO save (PatientDTO patientDTO);

    List<PatientDTO> listAll();

    PatientDTO searchById(Long id);

    void update(Patient dentist);

    boolean delete(Long id);
}
