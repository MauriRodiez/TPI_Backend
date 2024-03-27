package com.dh.dental.clinic.controller.entityController;

import com.dh.dental.clinic.controller.DTOResponseController;
import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.service.ICRUDService;
import com.dh.dental.clinic.dto.entityDTO.impl.PatientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/patient")
public class PatientController {

    private final ICRUDService<PatientDTO> patientService;
    private final DTOResponseController dtoResponseController = new DTOResponseController();

    public PatientController(ICRUDService<PatientDTO> patientService){
        this.patientService = patientService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPatient(@RequestBody PatientDTO patientDTO) {
        DTOResponse patientDTOResponse = patientService.save(patientDTO);
        return dtoResponseController.getHttpResponse(patientDTOResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatient(@PathVariable Long id){
        DTOResponse patientDTOResponse = patientService.searchById(id);
        return dtoResponseController.getHttpResponse(patientDTOResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPatients(){
        DTOResponse patientsDTOResponse = patientService.listAll();
        return dtoResponseController.getHttpResponse(patientsDTOResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePatient(@RequestBody PatientDTO patientDTO){
        DTOResponse patientDTOResponse = patientService.update(patientDTO);
        return dtoResponseController.getHttpResponse(patientDTOResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id){
        DTOResponse patientDTOResponse = patientService.delete(id);
        return dtoResponseController.getHttpResponse(patientDTOResponse);
    }
}
