package com.dh.dental.clinic.dto;

import com.dh.dental.clinic.entity.Appoinment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DentistDTO {

    private String name;
    private String surname;
    private String enrollment;
    private Set<Appoinment> appoinmentSet;

}
