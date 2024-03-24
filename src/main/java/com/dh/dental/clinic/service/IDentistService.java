package com.dh.dental.clinic.service;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.dto.entityDTO.impl.DentistDTO;


public interface IDentistService {

    DTOResponse save (DentistDTO dentistDTO);

    DTOResponse listAll();

    DTOResponse searchById(Long id);

    DTOResponse update(DentistDTO dentistDTO);

    DTOResponse delete(Long id);


}
