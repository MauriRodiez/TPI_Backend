package com.dh.dental.clinic.controller;

import com.dh.dental.clinic.service.IDentistService;
import com.dh.dental.clinic.entity.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    private IDentistService dentistService;

    @Autowired
    public DentistController(IDentistService dentistService){
        this.dentistService = dentistService;
    }

    @PostMapping
    public ResponseEntity<Dentist> save(@RequestBody Dentist dentist){
        return ResponseEntity.ok(dentistService.save(dentist));
    }

    @GetMapping
    public ResponseEntity<List<Dentist>> listAll(){
        return ResponseEntity.ok(dentistService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentist> searchById(@PathVariable Long id){
        return ResponseEntity.ok(dentistService.searchById(id));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Dentist dentist){

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

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return dentistService.delete(id);
    }

}
