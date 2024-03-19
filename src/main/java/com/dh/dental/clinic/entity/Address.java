package com.dh.dental.clinic.entity;

public class Address {
    private Long id;
    private String street;
    private String number;
    private String state;

    public Address() {
    }

    public Address(String street, String number, String state) {
        this.street = street;
        this.number = number;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
