package com.dh.dental.clinic.repository.impl;

import com.dh.dental.clinic.entity.Dentist;
import com.dh.dental.clinic.repository.IGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends IGenericRepository<Dentist, Long> {
    @Override
    @Query("DELETE FROM Dentist a WHERE a.id = ?1")
    void forcedDeleteById(Long id);
}
