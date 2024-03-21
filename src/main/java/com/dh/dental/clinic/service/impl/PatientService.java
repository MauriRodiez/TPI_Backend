package com.dh.dental.clinic.service.impl;

import com.dh.dental.clinic.service.IPatientService;
import com.dh.dental.clinic.dto.PatientDTO;
import com.dh.dental.clinic.entity.Patient;
import com.dh.dental.clinic.repository.IPatientRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {

    private IPatientRepository patientRepository;
    private static final Logger LOGGER = Logger.getLogger(PatientService.class);
    @Autowired
    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient save(Patient patient) {
        LOGGER.info("La fecha ingresada del paciente es " + patient.getRegistrationDate());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = patient.getRegistrationDate().format(formatter);
        LocalDate convertedDate = LocalDate.parse(formattedDate, formatter);
        patient.setRegistrationDate(convertedDate);
        LOGGER.info("La fecha convertida es " + patient.getRegistrationDate());
        return patientRepository.save(patient);
    }

    @Override
    public List<PatientDTO> listAll() {
        List<Patient> patientList = patientRepository.findAll();
        List<PatientDTO> patientDTOList = new ArrayList<>();
        if (!patientList.isEmpty()){
            for (Patient patient : patientList) {
                PatientDTO patientDTO = new PatientDTO(patient.getName(), patient.getSurname(), patient.getDni(), patient.getAddress(), patient.getAppoinmentList());
                patientDTOList.add(patientDTO);
            }
            return  patientDTOList;
        } else {
            return null;
        }
    }

    @Override
    public PatientDTO searchById(Long id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);

        if(patientOptional.isPresent()){
            Patient patient = patientOptional.get();
            PatientDTO patientDTO = new PatientDTO(patient.getName(), patient.getSurname(), patient.getDni(), patient.getAddress(), patient.getAppoinmentList());
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
