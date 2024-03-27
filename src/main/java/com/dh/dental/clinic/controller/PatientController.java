package com.dh.dental.clinic.controller;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.service.ICRUDService;
import com.dh.dental.clinic.dto.PatientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/patient")
public class PatientController {

    private final ICRUDService<PatientDTO> patientService;
    private final GenericResponseController genericResponseController = new GenericResponseController();

    public PatientController(ICRUDService<PatientDTO> patientService){
        this.patientService = patientService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPatient(@RequestBody PatientDTO patientDTO) {
        DTOResponse patientDTOResponse = patientService.save(patientDTO);
        return genericResponseController.getHttpResponse(patientDTOResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatient(@PathVariable Long id){
        DTOResponse patientDTOResponse = patientService.searchById(id);
        return genericResponseController.getHttpResponse(patientDTOResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPatients(){
        DTOResponse patientsDTOResponse = patientService.listAll();
        return genericResponseController.getHttpResponse(patientsDTOResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePatient(@RequestBody PatientDTO patientDTO){
        DTOResponse patientDTOResponse = patientService.update(patientDTO);
        return genericResponseController.getHttpResponse(patientDTOResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id){
        DTOResponse patientDTOResponse = patientService.delete(id);
        return genericResponseController.getHttpResponse(patientDTOResponse);
    }
}
