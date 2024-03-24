package com.dh.dental.clinic.service.impl;

import com.dh.dental.clinic.dto.entityDTO.impl.DentistDTO;
import com.dh.dental.clinic.entity.Dentist;
import com.dh.dental.clinic.repository.IDentistRepository;
import com.dh.dental.clinic.service.IDentistService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DentistService implements IDentistService {

    private IDentistRepository dentistrepository;
    ModelMapper modelMapper = new ModelMapper();
    public DentistService(IDentistRepository dentistrepository) {
        this.dentistrepository = dentistrepository;
    }

    @Override
    public DentistDTO save(DentistDTO dentistDTO) {
        Dentist dentist = modelMapper.map(dentistDTO, Dentist.class);
        dentistrepository.save(dentist);
        DentistDTO dentistDTOresponse = modelMapper.map(dentist, DentistDTO.class);
        return dentistDTOresponse;
    }

    @Override
    public List<DentistDTO> listAll() {
        List<Dentist> dentistList = dentistrepository.findAll();
        List<DentistDTO> dentistDTOList = new ArrayList<>();
        if(!dentistList.isEmpty()){
            for (Dentist dentist : dentistList){
                DentistDTO dentistDTO = modelMapper.map(dentist, DentistDTO.class);
                dentistDTOList.add(dentistDTO);
            }
        }
        return dentistDTOList;
    }

    @Override
    public DentistDTO searchById(Long id) {

        Optional<Dentist> dentistOptional = dentistrepository.findById(id);

        if(dentistOptional.isPresent()){
            DentistDTO dentistDTO = modelMapper.map(dentistOptional.get(), DentistDTO.class);
            return dentistDTO;
        } else {
            return null;
        }
    }

    @Override
    public void update(Dentist dentist) {
        dentistrepository.save(dentist);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Dentist> dentistOptional = dentistrepository.findById(id);
        if(dentistOptional.isPresent()){
            dentistrepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
