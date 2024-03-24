package com.dh.dental.clinic.service.impl;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.service.IPatientService;
import com.dh.dental.clinic.dto.entityDTO.impl.PatientDTO;
import com.dh.dental.clinic.entity.Patient;
import com.dh.dental.clinic.repository.IPatientRepository;
import com.dh.dental.clinic.service.dao.CreateDAO;
import com.dh.dental.clinic.service.dao.DeleteDAO;
import com.dh.dental.clinic.service.dao.ReadDAO;
import com.dh.dental.clinic.service.dao.UpdateDAO;
import org.springframework.stereotype.Service;
@Service
public class PatientService implements IPatientService {
    private final IPatientRepository patientRepository;
    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Override
    public DTOResponse<PatientDTO> save(PatientDTO patientDTO) {
        CreateDAO createDAO = new CreateDAO();
        return createDAO.create(
                patientDTO,
                PatientDTO.class,
                Patient.class,
                patientRepository);
    }

    @Override
    public DTOResponse<PatientDTO> listAll() {
        ReadDAO readDAO = new ReadDAO();
        return readDAO.readAll(PatientDTO.class, Patient.class, patientRepository);
    }

    @Override
    public DTOResponse<PatientDTO> searchById(Long id) {
        ReadDAO readDAO = new ReadDAO();
        return readDAO.readById(PatientDTO.class, Patient.class,patientRepository, id);
    }

    @Override
    public DTOResponse<PatientDTO> update(PatientDTO patientDTO) {
        UpdateDAO updateDAO = new UpdateDAO();
        return updateDAO.update(
                patientDTO,
                PatientDTO.class,
                Patient.class,
                patientRepository);
    }

    @Override
    public DTOResponse<PatientDTO> delete(Long id) {
        DeleteDAO deleteDAO = new DeleteDAO();
        return deleteDAO.delete(Patient.class, patientRepository, id);
    }
}
