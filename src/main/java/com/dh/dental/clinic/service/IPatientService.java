package com.dh.dental.clinic.service;

import com.dh.dental.clinic.dto.PatientDTO;
import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.entity.Patient;

import java.util.List;

public interface IPatientService {
    DTOResponse save (PatientDTO patientDTO);

    DTOResponse listAll();

    DTOResponse searchById(Long id);

    DTOResponse update(PatientDTO patientDTO);

    DTOResponse delete(Long id);
}
