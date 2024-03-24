package com.dh.dental.clinic.repository.impl;

import com.dh.dental.clinic.entity.Appointment;
import com.dh.dental.clinic.entity.Patient;
import com.dh.dental.clinic.repository.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends IGenericRepository<Patient, Long> {
}
