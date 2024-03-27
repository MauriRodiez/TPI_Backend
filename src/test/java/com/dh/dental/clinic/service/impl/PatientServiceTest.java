package com.dh.dental.clinic.service.impl;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.dto.PatientDTO;
import com.dh.dental.clinic.entity.Address;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;
    ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    ModelMapper modelMapper = new ModelMapper();
    PatientDTO patientDTOSaved;

    DTOResponse<PatientDTO> patientDTOResponseSave;
    DTOResponse<PatientDTO> patientDTOResponseUpdate;
    DTOResponse<PatientDTO> patientDTOResponseDelete;
    DTOResponse patientDTOResponseSearchById;

    Long entityID;
    Long addressID;

    public void assertResponse(DTOResponse<PatientDTO> patientDTOResponse, String patientDTOExpected)
            throws JsonProcessingException {

        String patientDTOResponseJson = objectMapper.writeValueAsString(patientDTOResponse);

        assertEquals(patientDTOExpected, patientDTOResponseJson);
    }

    @BeforeEach
    void setUp() throws JsonProcessingException {
        // data initialize
        Address address = new Address();
        address.setStreet("Av italia");
        address.setNumber("123");
        address.setState("Montevideo");

        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setDni("123");
        patientDTO.setName("Raul");
        patientDTO.setSurname("Perez");
        patientDTO.setRegistrationDate(LocalDate.now());
        patientDTO.setAddress(address);

        // prepare save
        patientDTOResponseSave = patientService.save(patientDTO);
        patientDTOSaved = (PatientDTO) patientDTOResponseSave.getData().get(0).get("Patient");
        entityID = patientDTOSaved.getId();
        addressID = patientDTOSaved.getAddress().getId();

        // prepare update
        PatientDTO patientDTOForUpdate = modelMapper.map(patientDTO, PatientDTO.class);
        patientDTOForUpdate.setId(entityID);
        patientDTOForUpdate.setName("Robertito");
        patientDTOResponseUpdate = patientService.update(patientDTOForUpdate);

        // prepare searchById
        patientDTOResponseSearchById = patientService.searchById(entityID);

        // prepare delete
        patientDTOResponseDelete = patientService.delete(entityID);
    }

    @Test
    @Order(1)
    void save() throws JsonProcessingException {
        String patientDtoExpected = "{\"message\":\"Patient saved successfully\","
                +"\"data\":[{\"Patient\":{\"id\":"+ entityID +",\"name\":\"Raul\","
                +"\"surname\":\"Perez\",\"dni\":\"123\",\"registrationDate\":[2024,3,24],"
                +"\"address\":{\"id\":"+ addressID +",\"street\":\"Av italia\",\"number\":"
                +"\"123\",\"state\":\"Montevideo\"},\"appoinmentList\":[]}}]}";
        assertResponse(patientDTOResponseSave, patientDtoExpected);
    }

    @Test
    @Order(2)
    void update() throws JsonProcessingException {
        String patientDtoExpected = "{\"message\":\"Patient updated successfully: {}"
        +"\",\"data\":[{\"Patient\":{\"id\":"+ entityID +",\"name\":\"Robertito\",\"surname\":\"Perez\","
        +"\"dni\":\"123\",\"registrationDate\":[2024,3,24],\"address\":{\"id\":"+ addressID + ",\"street\":"
        +"\"Av italia\",\"number\":\"123\",\"state\":\"Montevideo\"},\"appoinmentList\":[]}}]}";

        assertResponse(patientDTOResponseUpdate, patientDtoExpected);
    }

    @Test
    @Order(4)
    void delete() throws JsonProcessingException {
        String patientDTOExpected = "{\"message\":\"Patient deleted succesfully: {}\",\"data\":[]}";
        assertResponse(patientDTOResponseDelete, patientDTOExpected);
    }

    @Test
    @Order(3)
    void searchById() throws JsonProcessingException {
        String patientDTOExpected = "{\"message\":\"Patient successfully found {}"
        +"\",\"data\":[{\"Patient\":{\"id\":" + entityID + ",\"name\":\"Robertito\",\"surname\":\"Perez"
        +"\",\"dni\":\"123\",\"registrationDate\":[2024,3,24],\"address\":"
        + "{\"id\":" + addressID + ",\"street\":\"Av italia\",\"number\":\"123\",\"state"
        + "\":\"Montevideo\"},\"appoinmentList\":[]}}]}";

        assertResponse(patientDTOResponseSearchById, patientDTOExpected);
    }
}