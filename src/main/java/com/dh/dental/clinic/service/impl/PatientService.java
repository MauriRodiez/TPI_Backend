package com.dh.dental.clinic.service.impl;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.service.IPatientService;
import com.dh.dental.clinic.dto.PatientDTO;
import com.dh.dental.clinic.entity.Patient;
import com.dh.dental.clinic.repository.IPatientRepository;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {
    private IPatientRepository patientRepository;
    private static final Logger LOGGER = Logger.getLogger(PatientService.class);
    private static final ModelMapper modelMapper = new ModelMapper();

    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public DTOResponse save(PatientDTO patientDTO) {
        Patient patient = modelMapper.map(patientDTO, Patient.class);
        DTOResponse patientDTOResponse = new DTOResponse();
        try {
            patientRepository.save(patient);
            PatientDTO patientDTOEntity = modelMapper.map(patient, PatientDTO.class);
            patientDTOResponse.getData().add(Collections.singletonMap("Patient", patientDTOEntity));
            patientDTOResponse.setMessage("Patient saved successfully: {}");
            LOGGER.info("Patient saved successfully: {}");
        } catch (Exception e) {
            patientDTOResponse.setMessage("Error saving patient: {} " + e.getMessage());
            LOGGER.error("Error saving patient: {} " + e.getMessage());
        }
        return patientDTOResponse;
    }

    @Override
    public DTOResponse listAll() {
        DTOResponse patientDTOResponse = new DTOResponse();
        try {
            List<Patient> patientList = patientRepository.findAll();
            List<PatientDTO> patientDTOList = new ArrayList<>();
            if (!patientList.isEmpty()){
                for (Patient patient : patientList) {
                    PatientDTO patientDTO = modelMapper.map(patient, PatientDTO.class);
                    patientDTOList.add(patientDTO);
                }
                patientDTOResponse.getData().add(Collections.singletonMap("Patients", patientDTOList));
                patientDTOResponse.setMessage("Request to see all patients completed successfully: {}");
            } else {
                patientDTOResponse.setMessage("Error: There are no registered patients");
            }
        } catch (Exception e) {
            patientDTOResponse.setMessage("Error saving patient: {} " + e.getMessage());
            LOGGER.error("Error saving patient: {} " + e.getMessage());
        }
        return patientDTOResponse;
    }

    @Override
    public DTOResponse searchById(Long id) {
        DTOResponse patientDTOResponse = new DTOResponse();
        try{
            Optional<Patient> patientOptional = patientRepository.findById(id);
            if(patientOptional.isPresent()){
                Patient patient = patientOptional.get();
                PatientDTO patientDTO = modelMapper.map(patient, PatientDTO.class);
                patientDTOResponse.setMessage("Patient successfully found {}");
                patientDTOResponse.getData().add(Collections.singletonMap("Patient", patientDTO));
            } else {
                patientDTOResponse.setMessage("Error: Patient not found {}");
            }
        } catch (Exception e) {
            patientDTOResponse.setMessage("Error searching patient: {} " + e.getMessage());
            LOGGER.error("Error searching patient: {} " + e.getMessage());
        }
        return patientDTOResponse;
    }

    @Override
    public DTOResponse update(PatientDTO patientDTO) {
        Patient patient = modelMapper.map(patientDTO, Patient.class);
        DTOResponse patientDTOResponse = new DTOResponse();
        try {
            patientRepository.save(patient);
            patientDTOResponse.setMessage("Patient updated successfully: {}");
            PatientDTO patientDTOEntity = modelMapper.map(patient, PatientDTO.class);
            patientDTOResponse.getData().add(Collections.singletonMap("Patient", patientDTOEntity));
        } catch (Exception e) {
            patientDTOResponse.setMessage("Error updating patient: {} " + e.getMessage());
            LOGGER.error("Error updating patient: {} " + e.getMessage());
        }
        return patientDTOResponse;
    }

    @Override
    public DTOResponse delete(Long id) {
        DTOResponse patientDTOResponse = new DTOResponse();
        try {
            if (!patientRepository.findById(id).isEmpty()){
                patientRepository.deleteById(id);
                patientDTOResponse.setMessage("Patient deleted succesfully: {}");
            } else {
                patientDTOResponse.setMessage("Error: Patient not found: {}");
            }
        } catch (Exception e) {
            patientDTOResponse.setMessage("Error deleting patient: {} " + e.getMessage());
            LOGGER.error("Error deleting patient: {} " + e.getMessage());
        }
        return patientDTOResponse;
    }


}
