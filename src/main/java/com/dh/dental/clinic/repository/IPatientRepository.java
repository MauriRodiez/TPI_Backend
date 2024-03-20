package com.dh.dental.clinic.repository;

import com.dh.dental.clinic.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient, Long> {
}
