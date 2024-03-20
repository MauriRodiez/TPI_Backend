package com.dh.dental.clinic.repository;

import com.dh.dental.clinic.entity.Appoinment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IappoinmentRepository extends JpaRepository<Appoinment, Long> {
}
