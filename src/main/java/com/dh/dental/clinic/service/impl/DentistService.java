package com.dh.dental.clinic.service.impl;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.dto.DentistDTO;
import com.dh.dental.clinic.entity.Dentist;
import com.dh.dental.clinic.repository.impl.IDentistRepository;
import com.dh.dental.clinic.service.ICRUDService;
import com.dh.dental.clinic.mapper.CreateDAO;
import com.dh.dental.clinic.mapper.DeleteDAO;
import com.dh.dental.clinic.mapper.ReadDAO;
import com.dh.dental.clinic.mapper.UpdateDAO;
import org.springframework.stereotype.Service;

@Service
public class DentistService implements ICRUDService<DentistDTO> {

    private final IDentistRepository dentistRepository;
    public DentistService(IDentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }
    ReadDAO readDAO = new ReadDAO();
    CreateDAO createDAO = new CreateDAO();
    UpdateDAO updateDAO = new UpdateDAO();
    DeleteDAO deleteDAO = new DeleteDAO();

    @Override
    public DTOResponse<DentistDTO> save(DentistDTO dentistDTO) {
        return createDAO.create(
                dentistDTO,
                DentistDTO.class,
                Dentist.class,
                dentistRepository);
    }

    @Override
    public DTOResponse<DentistDTO> listAll() {
        return readDAO.readAll(DentistDTO.class, Dentist.class, dentistRepository);
    }

    @Override
    public DTOResponse<DentistDTO> searchById(Long id) {
        return readDAO.readById(DentistDTO.class,Dentist.class,dentistRepository, id);
    }

    @Override
    public DTOResponse<DentistDTO> update(DentistDTO dentistDTO) {
        return updateDAO.update(
                dentistDTO,
                DentistDTO.class,
                Dentist.class,
                dentistRepository);
    }

    @Override
    public DTOResponse<DentistDTO> delete(Long id){
        return deleteDAO.delete(Dentist.class, dentistRepository, id);
    }
}
