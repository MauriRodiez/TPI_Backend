package com.dh.dental.clinic.service.impl;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.dto.entityDTO.impl.DentistDTO;
import com.dh.dental.clinic.entity.Dentist;
import com.dh.dental.clinic.repository.impl.IDentistRepository;
import com.dh.dental.clinic.service.ICRUDService;
import com.dh.dental.clinic.service.dao.CreateDAO;
import com.dh.dental.clinic.service.dao.DeleteDAO;
import com.dh.dental.clinic.service.dao.ReadDAO;
import com.dh.dental.clinic.service.dao.UpdateDAO;
import org.springframework.stereotype.Service;

@Service
public class DentistService implements ICRUDService<DentistDTO> {

    private final IDentistRepository dentistRepository;
    public DentistService(IDentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public DTOResponse<DentistDTO> save(DentistDTO dentistDTO) {
        CreateDAO createDAO = new CreateDAO();
        return createDAO.create(
                dentistDTO,
                DentistDTO.class,
                Dentist.class,
                dentistRepository);
    }

    @Override
    public DTOResponse<DentistDTO> listAll() {
        ReadDAO readDAO = new ReadDAO();
        return readDAO.readAll(DentistDTO.class, Dentist.class, dentistRepository);
    }

    @Override
    public DTOResponse<DentistDTO> searchById(Long id) {
        ReadDAO readDAO = new ReadDAO();
        return readDAO.readById(DentistDTO.class,Dentist.class,dentistRepository, id);
    }

    @Override
    public DTOResponse<DentistDTO> update(DentistDTO dentistDTO) {
        UpdateDAO updateDAO = new UpdateDAO();
        return updateDAO.update(
                dentistDTO,
                DentistDTO.class,
                Dentist.class,
                dentistRepository);
    }

    @Override
    public DTOResponse<DentistDTO> delete(Long id){
        DeleteDAO deleteDAO = new DeleteDAO();
        return deleteDAO.delete(Dentist.class, dentistRepository, id);
    }
}
