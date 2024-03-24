package com.dh.dental.clinic.service;


import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.dto.entityDTO.impl.AppointmentDTO;

public interface IAppoinmentService {

    DTOResponse save (AppointmentDTO appoinmentDTO);

    DTOResponse listAll();

    DTOResponse searchById(Long id);

    DTOResponse update(AppointmentDTO appoinmentDTO);

    DTOResponse delete(Long id);

}
