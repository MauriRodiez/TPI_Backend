package com.dh.dental.clinic.Service.impl;

import com.dh.dental.clinic.Service.IdentistService;
import com.dh.dental.clinic.entity.Dentist;
import com.dh.dental.clinic.repository.IdentistReepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class dentistService implements IdentistService {

    private IdentistReepository dentistrepository;

    @Override
    public Dentist save(Dentist dentist) {
        return dentistrepository.save(dentist);
    }

    @Override
    public List<Dentist> listAll(Long id) {
        return null;
    }

    @Override
    public Optional<Dentist> searchById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Dentist dentist) {

    }
}
