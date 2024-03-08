package com.dh.dental.clinic.model.entit.entities;


import java.util.Date;

public class Patient {

    private Long id;
    private String name;
    private String surname;
    private Address address;
    private String dni;
    private Date registrationDate;

    /* Hay que ver como traer este dato del objeto usuario*/
    private User idUser;

    public Patient() {
    }

    public Patient(String name, String surname, Address address, String dni, Date registrationDate) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.dni = dni;
        this.registrationDate = registrationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
