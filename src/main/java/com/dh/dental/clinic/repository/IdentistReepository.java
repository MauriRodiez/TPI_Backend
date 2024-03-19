package com.dh.dental.clinic.repository;

import com.dh.dental.clinic.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentistReepository extends JpaRepository<Dentist, Long> {
}
