package com.dh.dental.clinic.service;

import com.dh.dental.clinic.dto.DentistDTO;
import com.dh.dental.clinic.entity.Dentist;

import java.util.List;

public interface IDentistService {

    DentistDTO save (DentistDTO dentistDTO);

    List<DentistDTO> listAll();

    DentistDTO searchById(Long id);

    void update(Dentist dentist);

    boolean delete(Long id);


}
