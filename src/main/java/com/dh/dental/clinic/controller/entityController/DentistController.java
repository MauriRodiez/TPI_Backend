package com.dh.dental.clinic.controller.entityController;

import com.dh.dental.clinic.controller.DTOResponseController;
import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.dto.entityDTO.impl.DentistDTO;
import com.dh.dental.clinic.service.ICRUDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/dentist")
public class DentistController {

    private ICRUDService<DentistDTO> dentistService;
    private final DTOResponseController dtoResponseController = new DTOResponseController();

    public DentistController(ICRUDService<DentistDTO> dentistService){
        this.dentistService = dentistService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createDentist(@RequestBody DentistDTO dentistDTO){
        DTOResponse<DentistDTO> dentistDTOResponse = dentistService.save(dentistDTO);
        return dtoResponseController.getHttpResponse(dentistDTOResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDentist(@PathVariable Long id){
        DTOResponse dentistDTOResponse = dentistService.searchById(id);
        return dtoResponseController.getHttpResponse(dentistDTOResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllDentist(){
        DTOResponse dentistDTOResponse = dentistService.listAll();
        return dtoResponseController.getHttpResponse(dentistDTOResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDentist(@RequestBody DentistDTO dentistDTO){
        DTOResponse<DentistDTO> dentistDTOResponse = dentistService.update(dentistDTO);
        return dtoResponseController.getHttpResponse(dentistDTOResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDentist(@PathVariable Long id){
        DTOResponse<DentistDTO> dentistDTOResponse = dentistService.delete(id);
        return dtoResponseController.getHttpResponse(dentistDTOResponse);
    }

}
