package com.dh.dental.clinic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "adresses")
public class Address {
    @Id
    private Long id;
    private String street;
    private String number;
    private String state;

    @OneToOne(mappedBy = "address")
    private Patient patient;

}
