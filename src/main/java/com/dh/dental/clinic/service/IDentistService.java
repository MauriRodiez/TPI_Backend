package com.dh.dental.clinic.service;

import com.dh.dental.clinic.entity.Dentist;

import java.util.List;

public interface IDentistService {

    Dentist save (Dentist dentist);

    List<Dentist> listAll();

    Dentist searchById(Long id);

    void update(Dentist dentist);

    boolean delete(Long id);


}
