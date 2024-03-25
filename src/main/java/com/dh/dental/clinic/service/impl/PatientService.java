package com.dh.dental.clinic.service.impl;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.service.ICRUDService;
import com.dh.dental.clinic.dto.entityDTO.impl.PatientDTO;
import com.dh.dental.clinic.entity.Patient;
import com.dh.dental.clinic.repository.impl.IPatientRepository;
import com.dh.dental.clinic.service.dao.CreateDAO;
import com.dh.dental.clinic.service.dao.DeleteDAO;
import com.dh.dental.clinic.service.dao.ReadDAO;
import com.dh.dental.clinic.service.dao.UpdateDAO;
import org.springframework.stereotype.Service;
@Service
public class PatientService implements ICRUDService<PatientDTO> {
    private final IPatientRepository patientRepository;
    private final CreateDAO createDAO = new CreateDAO();
    private final ReadDAO readDAO = new ReadDAO();
    private final UpdateDAO updateDAO = new UpdateDAO();
    private final DeleteDAO deleteDAO = new DeleteDAO();
    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Override
    public DTOResponse<PatientDTO> save(PatientDTO patientDTO) {
        return createDAO.create(
                patientDTO,
                PatientDTO.class,
                Patient.class,
                patientRepository);
    }

    @Override
    public DTOResponse<PatientDTO> listAll() {
        return readDAO.readAll(PatientDTO.class, Patient.class, patientRepository);
    }

    @Override
    public DTOResponse<PatientDTO> searchById(Long id) {
        return readDAO.readById(PatientDTO.class, Patient.class,patientRepository, id);
    }

    @Override
    public DTOResponse<PatientDTO> update(PatientDTO patientDTO) {
        return updateDAO.update(
                patientDTO,
                PatientDTO.class,
                Patient.class,
                patientRepository);
    }

    @Override
    public DTOResponse<PatientDTO> delete(Long id) {
        return deleteDAO.delete(Patient.class, patientRepository, id);
    }
}
