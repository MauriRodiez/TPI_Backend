package com.dh.dental.clinic.controller;

import com.dh.dental.clinic.Service.IappoinmentService;
import com.dh.dental.clinic.entity.Appoinment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appoinment")
public class appoinmentController {

    private IappoinmentService appoinmentService;
    @Autowired
    public appoinmentController(IappoinmentService appoinmentService) {
        this.appoinmentService = appoinmentService;
    }

    @PostMapping
    public ResponseEntity<Appoinment> save(@RequestBody Appoinment appoinment){
        return ResponseEntity.ok(appoinmentService.save(appoinment));
    }

    @GetMapping
    public ResponseEntity<List<Appoinment>> listAll(){
        return ResponseEntity.ok(appoinmentService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appoinment> searchById(@PathVariable Long id){
        return ResponseEntity.ok(appoinmentService.searchById(id));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Appoinment dentist){

        ResponseEntity<String> response;
        Appoinment appoinmentFoundIt = appoinmentService.searchById(dentist.getId());

        if (appoinmentFoundIt != null){
            appoinmentService.update(dentist);
            response = ResponseEntity.ok("El Turno se actualizo correctamente.");
        } else {
            response = ResponseEntity.ok().body("No se puede actualizar el turno");
        }

        return response;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return appoinmentService.delete(id);
    }
}
