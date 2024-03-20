package com.dh.dental.clinic.service.impl;

import com.dh.dental.clinic.service.IAppoinmentService;
import com.dh.dental.clinic.entity.Appoinment;
import com.dh.dental.clinic.repository.IappoinmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppoinmentService implements IAppoinmentService {

    private IappoinmentRepository appoinmentRepository;

    @Autowired
    public AppoinmentService(IappoinmentRepository appoinmentRepository) {
        this.appoinmentRepository = appoinmentRepository;
    }

    @Override
    public Appoinment save(Appoinment appoinment) {
        return appoinmentRepository.save(appoinment);
    }

    @Override
    public List<Appoinment> listAll() {
        return appoinmentRepository.findAll();
    }

    @Override
    public Appoinment searchById(Long id) {
        Optional<Appoinment> appoinmentOptional = appoinmentRepository.findById(id);

        if(appoinmentOptional.isPresent()){
            return appoinmentOptional.get();
        } else {
            return null;
        }
    }

    @Override
    public void update(Appoinment appoinment) {
        appoinmentRepository.save(appoinment);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Appoinment> appoinmentOptional = appoinmentRepository.findById(id);
        if(appoinmentOptional.isPresent()){
            appoinmentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
