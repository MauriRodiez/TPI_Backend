package com.dh.dental.clinic.service.impl;

import com.dh.dental.clinic.service.IDentistService;
import com.dh.dental.clinic.entity.Dentist;
import com.dh.dental.clinic.repository.IdentistReepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService implements IDentistService {

    private IdentistReepository dentistrepository;
    @Autowired
    public DentistService(IdentistReepository dentistrepository) {
        this.dentistrepository = dentistrepository;
    }

    @Override
    public Dentist save(Dentist dentist) {
        return dentistrepository.save(dentist);
    }

    @Override
    public List<Dentist> listAll() {
        return dentistrepository.findAll();
    }

    @Override
    public Dentist searchById(Long id) {

        Optional<Dentist> dentistOptional = dentistrepository.findById(id);

        if(dentistOptional.isPresent()){
            return dentistOptional.get();
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
