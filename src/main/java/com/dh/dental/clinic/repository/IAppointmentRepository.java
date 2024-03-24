package com.dh.dental.clinic.repository;

import com.dh.dental.clinic.entity.Appointment;
import com.dh.dental.clinic.entity.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepository extends IGenericRepository<Appointment, Long>  {
}
