package com.dh.dental.clinic.repository.impl;

import com.dh.dental.clinic.entity.Appointment;
import com.dh.dental.clinic.entity.Patient;
import com.dh.dental.clinic.repository.IGenericRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IAppointmentRepository extends IGenericRepository<Appointment, Long> {
    @Override
    @Modifying
    @Transactional
    @Query("DELETE FROM Appointment a WHERE a.id = ?1")
    void forcedDeleteById(Long id);
}
