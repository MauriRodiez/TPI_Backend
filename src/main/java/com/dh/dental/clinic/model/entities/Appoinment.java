package com.dh.dental.clinic.model.entit.entities;

import java.sql.Time;
import java.util.Date;

public class Appoinment {
    private Long id;
    private Date dateAppinment;
    private Time hour;
    private Patient idPatient;
    private Dentist iddentist;

    public Appoinment() {
    }

    public Appoinment(Date dateAppinment, Time hour, Patient idPatient, Dentist iddentist) {
        this.dateAppinment = dateAppinment;
        this.hour = hour;
        this.idPatient = idPatient;
        this.iddentist = iddentist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateAppinment() {
        return dateAppinment;
    }

    public void setDateAppinment(Date dateAppinment) {
        this.dateAppinment = dateAppinment;
    }

    public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    public Patient getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Patient idPatient) {
        this.idPatient = idPatient;
    }

    public Dentist getIddentist() {
        return iddentist;
    }

    public void setIddentist(Dentist iddentist) {
        this.iddentist = iddentist;
    }
}
