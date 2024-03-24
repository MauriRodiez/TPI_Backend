package com.dh.dental.clinic.controller;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.dto.entityDTO.impl.DentistDTO;
import com.dh.dental.clinic.service.IDentistService;
import com.dh.dental.clinic.service.impl.DentistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/dentist")
public class DentistController {

    private IDentistService dentistService;


    public DentistController(DentistService dentistService){
        this.dentistService = dentistService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createDentist(@RequestBody DentistDTO dentistDTO){
        DTOResponse<DentistDTO> dentistDTOResponse = dentistService.save(dentistDTO);
        if (dentistDTOResponse.getMessage().toLowerCase().contains("error")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(dentistDTOResponse);
        } else {
            return ResponseEntity.ok(dentistDTOResponse);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDentist(@PathVariable Long id){
        DTOResponse dentistDTOResponse = dentistService.searchById(id);
        if (dentistDTOResponse.getMessage().toLowerCase().contains("error")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(dentistDTOResponse);
        } else {
            return ResponseEntity.ok(dentistDTOResponse);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllDentist(){
        DTOResponse dentistDTOResponse = dentistService.listAll();
        if (dentistDTOResponse.getMessage().toLowerCase().contains("error")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(dentistDTOResponse);
        } else {
            return ResponseEntity.ok(dentistDTOResponse);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDentist(@RequestBody DentistDTO dentistDTO){
        DTOResponse<DentistDTO> dentistDTOResponse = dentistService.update(dentistDTO);
        if (dentistDTOResponse.getMessage().toLowerCase().contains("error")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(dentistDTOResponse);
        } else {
            return ResponseEntity.ok(dentistDTOResponse);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDentist(@PathVariable Long id){
        DTOResponse<DentistDTO> dentistDTOResponse = dentistService.delete(id);
        if (dentistDTOResponse.getMessage().toLowerCase().contains("error")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(dentistDTOResponse);
        } else {
            return ResponseEntity.ok(dentistDTOResponse);
        }
    }

}
