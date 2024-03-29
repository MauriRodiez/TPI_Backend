package com.dh.dental.clinic.controller;

import com.dh.dental.clinic.dto.AppointmentDTO;
import com.dh.dental.clinic.service.ICRUDService;
import com.dh.dental.clinic.service.impl.AppoinmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/appoinment")
public class AppoinmentController {

    private final ICRUDService<AppointmentDTO> appoinmentService;

    public AppoinmentController(AppoinmentService appoinmentService) {
        this.appoinmentService = appoinmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        return ResponseEntity.ok(appoinmentService.save(appointmentDTO));
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getAppointment(@PathVariable Long id){
        return ResponseEntity.ok(appoinmentService.searchById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllAppointments(){
        return ResponseEntity.ok(appoinmentService.listAll());
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAppointment(@RequestBody AppointmentDTO appointmentDTO){
        return ResponseEntity.ok(appoinmentService.update(appointmentDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long id){
        return ResponseEntity.ok(appoinmentService.delete(id));
    }
}
