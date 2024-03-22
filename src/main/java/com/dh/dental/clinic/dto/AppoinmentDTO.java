package com.dh.dental.clinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppoinmentDTO {
    private Long id;
    private String dateAppoinment;
    private Long patient_id;
    private Long dentist_id;

}
