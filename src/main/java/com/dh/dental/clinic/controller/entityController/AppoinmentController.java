package com.dh.dental.clinic.controller.entityController;

import com.dh.dental.clinic.controller.DTOResponseController;
import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.dto.entityDTO.impl.AppointmentDTO;
import com.dh.dental.clinic.service.ICRUDService;
import com.dh.dental.clinic.service.impl.AppoinmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appoinment")
public class AppoinmentController {

    private final ICRUDService<AppointmentDTO> appoinmentService;
    private final DTOResponseController dtoResponseController = new DTOResponseController();

    public AppoinmentController(AppoinmentService appoinmentService) {
        this.appoinmentService = appoinmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        DTOResponse appointmentDTOResponse = appoinmentService.save(appointmentDTO);
        return dtoResponseController.getHttpResponse(appointmentDTOResponse);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getAppointment(@PathVariable Long id){
        DTOResponse appointmentDTOResponse = appoinmentService.searchById(id);
        return dtoResponseController.getHttpResponse(appointmentDTOResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllAppointments(){
        DTOResponse appointmentsDTOResponse = appoinmentService.listAll();
        return dtoResponseController.getHttpResponse(appointmentsDTOResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAppointment(@RequestBody AppointmentDTO appointmentDTO){
        DTOResponse appointmentDTOResponse = appoinmentService.update(appointmentDTO);
        return dtoResponseController.getHttpResponse(appointmentDTOResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long id){
        DTOResponse appointmentDTOResponse = appoinmentService.delete(id);
        return dtoResponseController.getHttpResponse(appointmentDTOResponse);
    }
}
