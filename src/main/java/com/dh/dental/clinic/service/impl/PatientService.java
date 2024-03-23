package com.dh.dental.clinic.service.impl;

import com.dh.dental.clinic.service.IPatientService;
import com.dh.dental.clinic.dto.PatientDTO;
import com.dh.dental.clinic.entity.Patient;
import com.dh.dental.clinic.repository.IPatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {

    ObjectMapper objectMapper = new ObjectMapper();
    private IPatientRepository patientRepository;
    private static final Logger LOGGER = Logger.getLogger(PatientService.class);

    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientDTO save(PatientDTO patientDTO) {
        objectMapper.registerModule(new JavaTimeModule());

        Patient patient = objectMapper.convertValue(patientDTO, Patient.class);
        patientRepository.save(patient);
        PatientDTO patientDTOResponse = objectMapper.convertValue(patient, PatientDTO.class);
        return patientDTOResponse;
    }

    @Override
    public List<PatientDTO> listAll() {
        List<Patient> patientList = patientRepository.findAll();
        List<PatientDTO> patientDTOList = new ArrayList<>();
        if (!patientList.isEmpty()){
            for (Patient patient : patientList) {
//                PatientDTO patientDTO = new PatientDTO(patient.getName(), patient.getSurname(), patient.getDni(), patient.getRegistrationDate(), patient.getAddress(), patient.getAppoinmentList());
//                patientDTOList.add(patientDTO);
                return null;
            }
            return  patientDTOList;
        } else {
            return null;
        }
    }

    @Override
    public PatientDTO searchById(Long id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        objectMapper.registerModule(new JavaTimeModule());

        if(patientOptional.isPresent()){
            Patient patient = patientOptional.get();
            PatientDTO patientDTO = objectMapper.convertValue(patient, PatientDTO.class);
            return patientDTO;
        } else {
            return null;
        }
    }

    @Override
    public void update(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public boolean delete(Long id) {
        if (!patientRepository.findById(id).isEmpty()){
            patientRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }



}
