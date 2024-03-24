package com.dh.dental.clinic.service.impl;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.dto.entityDTO.impl.AppointmentDTO;
import com.dh.dental.clinic.entity.Appointment;
import com.dh.dental.clinic.repository.IAppointmentRepository;
import com.dh.dental.clinic.service.IAppoinmentService;
import com.dh.dental.clinic.service.dao.CreateDAO;
import com.dh.dental.clinic.service.dao.DeleteDAO;
import com.dh.dental.clinic.service.dao.ReadDAO;
import com.dh.dental.clinic.service.dao.UpdateDAO;
import org.springframework.stereotype.Service;

@Service
public class AppoinmentService implements IAppoinmentService {

    private final IAppointmentRepository appoinmentRepository;
    public AppoinmentService(IAppointmentRepository appoinmentRepository) {
        this.appoinmentRepository = appoinmentRepository;
    }

    @Override
    public DTOResponse<AppointmentDTO> save(AppointmentDTO appointmentDTO) {
        CreateDAO createDAO = new CreateDAO();
        return createDAO.create(appointmentDTO,
                AppointmentDTO.class,
                Appointment.class,
                appoinmentRepository);
    }

    @Override
    public DTOResponse<AppointmentDTO> listAll() {
        ReadDAO readDAO = new ReadDAO();
        return readDAO.readAll(AppointmentDTO.class,
                Appointment.class,
                appoinmentRepository);
    }

    @Override
    public DTOResponse<AppointmentDTO> searchById(Long id) {
        ReadDAO readDAO = new ReadDAO();
        return readDAO.readById(AppointmentDTO.class,
                Appointment.class,
                appoinmentRepository,
                id);
    }

    @Override
    public DTOResponse<AppointmentDTO> update(AppointmentDTO appoinmentDTO) {
        UpdateDAO updateDAO = new UpdateDAO();
        return updateDAO.update(
                appoinmentDTO,
                AppointmentDTO.class,
                Appointment.class,
                appoinmentRepository);
    }

    @Override
    public DTOResponse<AppointmentDTO> delete(Long id) {
        DeleteDAO deleteDAO = new DeleteDAO();
        return deleteDAO.delete(
                Appointment.class,
                appoinmentRepository,
                id);
    }
}
