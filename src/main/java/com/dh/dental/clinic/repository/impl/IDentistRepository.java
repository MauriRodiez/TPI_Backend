package com.dh.dental.clinic.repository.impl;

import com.dh.dental.clinic.entity.Dentist;
import com.dh.dental.clinic.repository.IGenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends IGenericRepository<Dentist, Long> {
}
