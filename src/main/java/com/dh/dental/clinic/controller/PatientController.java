package com.dh.dental.clinic.controller;

import com.dh.dental.clinic.service.impl.PatientService;
import com.dh.dental.clinic.dto.PatientDTO;
import com.dh.dental.clinic.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping("/create")
    public ResponseEntity createPatient(@RequestBody Patient patient){
        patientService.save(patient);
        return new ResponseEntity<>("Patient creado exitosamente", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable Long id){
        return new ResponseEntity<>(patientService.searchById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PatientDTO>> getAllPatients(){
        return new ResponseEntity<>(patientService.listAll(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updatePatient(@RequestBody Patient patient){
        patientService.update(patient);
        return new ResponseEntity<>("Patient actualizado exitosamente", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deletePatient(@PathVariable Long id){
        return new ResponseEntity<>(patientService.delete(id), HttpStatus.OK);
    }
}
