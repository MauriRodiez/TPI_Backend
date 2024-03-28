package com.dh.dental.clinic.service.impl;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.dto.AppointmentDTO;
import com.dh.dental.clinic.dto.DentistDTO;
import com.dh.dental.clinic.entity.Appointment;
import com.dh.dental.clinic.entity.Dentist;
import com.dh.dental.clinic.mapper.*;
import com.dh.dental.clinic.repository.impl.IAppointmentRepository;
import com.dh.dental.clinic.service.ICRUDService;
import org.springframework.stereotype.Service;

@Service
public class AppoinmentService implements ICRUDService<AppointmentDTO> {

    private final IAppointmentRepository appoinmentRepository;
    private final CRUDMapper<AppointmentDTO, Appointment> crudMapper;
    public AppoinmentService(IAppointmentRepository appoinmentRepository) {
        this.appoinmentRepository = appoinmentRepository;
        this.crudMapper = new CRUDMapper<AppointmentDTO, Appointment>(AppointmentDTO.class, Appointment.class, appoinmentRepository);
    }

    @Override
    public DTOResponse<AppointmentDTO> save(AppointmentDTO appointmentDTO) {
        return crudMapper.create(appointmentDTO);
    }

    @Override
    public DTOResponse<AppointmentDTO> listAll() {
        return crudMapper.readAll();
    }

    @Override
    public DTOResponse<AppointmentDTO> searchById(Long id) {
        return crudMapper.readById(id);
    }

    @Override
    public DTOResponse<AppointmentDTO> update(AppointmentDTO appointmentDTO) {
        return crudMapper.update(appointmentDTO);
    }

    @Override
    public DTOResponse<AppointmentDTO> delete(Long id) {
        return crudMapper.delete(id);
    }
}
