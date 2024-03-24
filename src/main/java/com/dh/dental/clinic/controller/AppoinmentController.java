package com.dh.dental.clinic.controller;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.dto.entityDTO.impl.AppointmentDTO;
import com.dh.dental.clinic.service.IAppointmentService;
import com.dh.dental.clinic.service.impl.AppoinmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appoinment")
public class AppoinmentController {

    private final IAppointmentService appoinmentService;

    public AppoinmentController(AppoinmentService appoinmentService) {
        this.appoinmentService = appoinmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        DTOResponse appointmentDTOResponse = appoinmentService.save(appointmentDTO);
        if (appointmentDTOResponse.getMessage().toLowerCase().contains("error")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(appointmentDTOResponse);
        } else {
            return ResponseEntity.ok(appointmentDTOResponse);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getAppointment(@PathVariable Long id){
        DTOResponse appointmentDTOResponse = appoinmentService.searchById(id);
        if (appointmentDTOResponse.getMessage().toLowerCase().contains("error")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(appointmentDTOResponse);
        } else {
            return ResponseEntity.ok(appointmentDTOResponse);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllAppointments(){
        DTOResponse appointmentsDTOResponse = appoinmentService.listAll();
        if (appointmentsDTOResponse.getMessage().toLowerCase().contains("error")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(appointmentsDTOResponse);
        } else {
            return ResponseEntity.ok(appointmentsDTOResponse);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAppointment(@RequestBody AppointmentDTO appointmentDTO){
        DTOResponse appointmentDTOResponse = appoinmentService.update(appointmentDTO);
        if (appointmentDTOResponse.getMessage().toLowerCase().contains("error")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(appointmentDTOResponse);
        } else {
            return ResponseEntity.ok(appointmentDTOResponse);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long id){
        DTOResponse appointmentDTOResponse = appoinmentService.delete(id);
        if (appointmentDTOResponse.getMessage().toLowerCase().contains("error")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(appointmentDTOResponse);
        } else {
            return ResponseEntity.ok(appointmentDTOResponse);
        }
    }
}
