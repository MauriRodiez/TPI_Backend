package com.dh.dental.clinic.controller;

import com.dh.dental.clinic.service.IAppoinmentService;
import com.dh.dental.clinic.entity.Appoinment;
import com.dh.dental.clinic.service.IDentistService;
import com.dh.dental.clinic.service.IPatientService;
import com.dh.dental.clinic.service.impl.AppoinmentService;
import com.dh.dental.clinic.service.impl.DentistService;
import com.dh.dental.clinic.service.impl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appoinment")
public class AppoinmentController {

    private IAppoinmentService appoinmentService;
    private IPatientService patientService;
    private IDentistService dentistService;

    public AppoinmentController(AppoinmentService appoinmentService, PatientService patientService, DentistService dentistService) {
        this.appoinmentService = appoinmentService;
        this.patientService = patientService;
        this.dentistService = dentistService;
    }

    @PostMapping("/create")
    public ResponseEntity<Appoinment> save(@RequestBody Appoinment appoinment){
        return ResponseEntity.ok(appoinmentService.save(appoinment));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Appoinment>> listAll(){
        return ResponseEntity.ok(appoinmentService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appoinment> searchById(@PathVariable Long id){
        return ResponseEntity.ok(appoinmentService.searchById(id));
    }

    @PutMapping("/update")
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

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return appoinmentService.delete(id);
    }
}
