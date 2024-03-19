package com.dh.dental.clinic.Service;

import com.dh.dental.clinic.entity.Dentist;

import java.util.List;
import java.util.Optional;

public interface IdentistService {

    Dentist save (Dentist dentist);

    List<Dentist> listAll(Long id);

    Optional<Dentist> searchById(Long id);

    void update(Dentist dentist);
}
