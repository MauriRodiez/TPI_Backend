package com.dh.dental.clinic.service;

import com.dh.dental.clinic.dto.entityDTO.impl.PatientDTO;
import com.dh.dental.clinic.dto.DTOResponse;

public interface IPatientService {
    DTOResponse save (PatientDTO patientDTO);

    DTOResponse listAll();

    DTOResponse searchById(Long id);

    DTOResponse update(PatientDTO patientDTO);

    DTOResponse delete(Long id);
}
