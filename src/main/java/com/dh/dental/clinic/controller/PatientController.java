package com.dh.dental.clinic.controller;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.service.impl.PatientService;
import com.dh.dental.clinic.dto.entityDTO.impl.PatientDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPatient(@RequestBody PatientDTO patientDTO) {
        DTOResponse<PatientDTO> patientDTOResponse = patientService.save(patientDTO);
        if (patientDTOResponse.getMessage().toLowerCase().contains("error")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(patientDTOResponse);
        } else {
            return ResponseEntity.ok(patientDTOResponse);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatient(@PathVariable Long id){
        DTOResponse patientDTOResponse = patientService.searchById(id);
        if (patientDTOResponse.getMessage().toLowerCase().contains("error")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(patientDTOResponse);
        } else {
            return ResponseEntity.ok(patientDTOResponse);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPatients(){
        DTOResponse patientsDTOResponse = patientService.listAll();
        if (patientsDTOResponse.getMessage().toLowerCase().contains("error")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(patientsDTOResponse);
        } else {
            return ResponseEntity.ok(patientsDTOResponse);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePatient(@RequestBody PatientDTO patientDTO){
        DTOResponse patientDTOResponse = patientService.update(patientDTO);
        if (patientDTOResponse.getMessage().toLowerCase().contains("error")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(patientDTOResponse);
        } else {
            return ResponseEntity.ok(patientDTOResponse);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id){
        DTOResponse patientDTOResponse = patientService.delete(id);
        if (patientDTOResponse.getMessage().toLowerCase().contains("error")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(patientDTOResponse);
        } else {
            return ResponseEntity.ok(patientDTOResponse);
        }
    }
}
