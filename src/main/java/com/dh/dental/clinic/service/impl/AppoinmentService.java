package com.dh.dental.clinic.service.impl;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.dto.entityDTO.impl.AppointmentDTO;
import com.dh.dental.clinic.entity.Appointment;
import com.dh.dental.clinic.repository.impl.IAppointmentRepository;
import com.dh.dental.clinic.service.ICRUDService;
import com.dh.dental.clinic.service.dao.CreateDAO;
import com.dh.dental.clinic.service.dao.DeleteDAO;
import com.dh.dental.clinic.service.dao.ReadDAO;
import com.dh.dental.clinic.service.dao.UpdateDAO;
import org.springframework.stereotype.Service;

@Service
public class AppoinmentService implements ICRUDService<AppointmentDTO> {

    private final IAppointmentRepository appoinmentRepository;
    CreateDAO createDAO = new CreateDAO();
    ReadDAO readDAO = new ReadDAO();
    UpdateDAO updateDAO = new UpdateDAO();
    DeleteDAO deleteDAO = new DeleteDAO();
    public AppoinmentService(IAppointmentRepository appoinmentRepository) {
        this.appoinmentRepository = appoinmentRepository;
    }

    @Override
    public DTOResponse<AppointmentDTO> save(AppointmentDTO appointmentDTO) {
        return createDAO.create(appointmentDTO,
                AppointmentDTO.class,
                Appointment.class,
                appoinmentRepository);
    }

    @Override
    public DTOResponse<AppointmentDTO> listAll() {
        return readDAO.readAll(AppointmentDTO.class,
                Appointment.class,
                appoinmentRepository);
    }

    @Override
    public DTOResponse<AppointmentDTO> searchById(Long id) {
        return readDAO.readById(AppointmentDTO.class,
                Appointment.class,
                appoinmentRepository,
                id);
    }

    @Override
    public DTOResponse<AppointmentDTO> update(AppointmentDTO appoinmentDTO) {
        return updateDAO.update(
                appoinmentDTO,
                AppointmentDTO.class,
                Appointment.class,
                appoinmentRepository);
    }

    @Override
    public DTOResponse<AppointmentDTO> delete(Long id) {
        return deleteDAO.delete(
                Appointment.class,
                appoinmentRepository,
                id);
    }
}
