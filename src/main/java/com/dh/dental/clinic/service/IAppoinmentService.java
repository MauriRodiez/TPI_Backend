package com.dh.dental.clinic.service;


import com.dh.dental.clinic.entity.Appoinment;

import java.util.List;

public interface IAppoinmentService {

    Appoinment save (Appoinment appoinment);

    List<Appoinment> listAll();

    Appoinment searchById(Long id);

    void update(Appoinment appoinment);

    boolean delete(Long id);

}
