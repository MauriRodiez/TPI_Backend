package com.dh.dental.clinic.model.entities;

import java.time.LocalDate;

public class Appoinment {
    private Long id;
    private LocalDate dateAppinment;
    private Patient patient;
    private Dentist dentist;

    public Appoinment() {
    }

    public Appoinment(LocalDate dateAppinment, Patient patient, Dentist dentist) {
        this.dateAppinment = dateAppinment;
        this.patient = patient;
        this.dentist = dentist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateAppinment() {
        return dateAppinment;
    }

    public void setDateAppinment(LocalDate dateAppinment) {
        this.dateAppinment = dateAppinment;
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
