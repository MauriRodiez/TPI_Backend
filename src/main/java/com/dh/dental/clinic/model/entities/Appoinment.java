package com.dh.dental.clinic.model.entities;

import java.time.LocalDate;

public class Appoinment {
    private Long id;
    private LocalDate dateAppoinment;
    private Patient patient;
    private Dentist dentist;

    public Appoinment() {
    }

    public Appoinment(LocalDate dateAppoinment, Patient patient, Dentist dentist) {
        this.dateAppoinment = dateAppoinment;
        this.patient = patient;
        this.dentist = dentist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateAppoinment() {
        return dateAppoinment;
    }

    public void setDateAppoinment(LocalDate dateAppoinment) {
        this.dateAppoinment = dateAppoinment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }
}
