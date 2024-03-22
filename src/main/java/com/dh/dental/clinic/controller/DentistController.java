package com.dh.dental.clinic.controller;

import com.dh.dental.clinic.service.IDentistService;
import com.dh.dental.clinic.entity.Dentist;
import com.dh.dental.clinic.service.impl.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    private IDentistService dentistService;


    public DentistController(DentistService dentistService){
        this.dentistService = dentistService;
    }

    @PostMapping("/create")
    public ResponseEntity<Dentist> createDentist(@RequestBody Dentist dentist){
        return ResponseEntity.ok(dentistService.save(dentist));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentist> getDentist(@PathVariable Long id){
        return ResponseEntity.ok(dentistService.searchById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Dentist>> getAllDentist(){
        return ResponseEntity.ok(dentistService.listAll());
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateDentist(@RequestBody Dentist dentist){

        ResponseEntity<String> response;
        Dentist dentistFoundIt = dentistService.searchById(dentist.getId());

        if (dentistFoundIt != null){
            dentistService.update(dentist);
            response = ResponseEntity.ok("El odontologo se actualizo correctamente.");
        } else {
            response = ResponseEntity.ok().body("No se puede actualizar el odontologo");
        }

        return response;
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteDentist(@PathVariable Long id){
        return dentistService.delete(id);
    }

}
