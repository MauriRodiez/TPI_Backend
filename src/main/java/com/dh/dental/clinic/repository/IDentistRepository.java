package com.dh.dental.clinic.repository;

import com.dh.dental.clinic.entity.Dentist;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends IGenericRepository<Dentist, Long>  {
}
