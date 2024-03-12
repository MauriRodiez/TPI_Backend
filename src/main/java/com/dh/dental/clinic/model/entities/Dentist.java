package com.dh.dental.clinic.model.entities;

public class Dentist {
    private Long id;
    private String name;
    private String surname;
    private String enrollment;

    /* Hay que ver como traer este dato del objeto usuario*/
    private  User idUser;

    public Dentist() {
    }

    public Dentist(String name, String surname, String enrollment) {
        this.name = name;
        this.surname = surname;
        this.enrollment = enrollment;
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

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

}
