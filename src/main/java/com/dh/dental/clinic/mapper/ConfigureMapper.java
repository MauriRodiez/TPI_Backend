package com.dh.dental.clinic.mapper;

import com.dh.dental.clinic.dto.AddressDTO;
import com.dh.dental.clinic.dto.AppointmentDTO;
import com.dh.dental.clinic.dto.DentistDTO;
import com.dh.dental.clinic.dto.PatientDTO;
import com.dh.dental.clinic.entity.Appointment;
import com.dh.dental.clinic.entity.Dentist;
import com.dh.dental.clinic.entity.Patient;
import com.dh.dental.clinic.repository.impl.IDentistRepository;
import com.dh.dental.clinic.service.impl.DentistService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.util.HashSet;
import java.util.Set;

public class ConfigureMapper {

    public ModelMapper modelMapper = new ModelMapper();

    public ModelMapper configureMapper() {

        /* ---------------------------------------------------------------------- */

        // TypeMap for Appointment
        TypeMap<Appointment, AppointmentDTO> appointmentMap = modelMapper.createTypeMap(Appointment.class, AppointmentDTO.class);

        // Converter for Appointment skiping AppointmentList in Patient
        Converter<Patient, PatientDTO> patientConverter = context -> {

            Patient source = context.getSource();
            PatientDTO destination = new PatientDTO();

            destination.setId(source.getId());

            if (source.getName() != null) {
                destination.setName(source.getName());
            }

            if (source.getSurname() != null){
                destination.setSurname(source.getSurname());
            }

            if (source.getDni() != null) {
                destination.setDni(source.getDni());
            }

            if (source.getRegistrationDate() != null) {
                destination.setRegistrationDate(source.getRegistrationDate());
            }

            if (source.getAddress() != null) {
                destination.setAddressDTO(modelMapper.map(source.getAddress(), AddressDTO.class));
            }

            return destination;
        };

        // Converter for Appointment skiping AppointmentList in Dentist
        Converter<Dentist, DentistDTO> dentistConverter = context -> {

            Dentist source = context.getSource();
            DentistDTO destination = new DentistDTO();

            destination.setId(source.getId());

            if (source.getName() != null){
                destination.setName(source.getName());
            }

            if (source.getSurname() != null){
                destination.setSurname(source.getSurname());
            }

            if (source.getEnrollment() != null){
                destination.setEnrollment(source.getEnrollment());
            }

            return destination;
        };

        // saving mappings
        appointmentMap.addMappings(mapper -> mapper.using(patientConverter).map(Appointment::getPatient, AppointmentDTO::setPatientDTO));
        appointmentMap.addMappings(mapper -> mapper.using(dentistConverter).map(Appointment::getDentist, AppointmentDTO::setDentistDTO));


        /* ---------------------------------------------------------------------- */


        // TypeMap for Patient
        TypeMap<Patient, PatientDTO> patientMap = modelMapper.createTypeMap(Patient.class, PatientDTO.class);

        // Converter for AppointmentList skiping Patient info
        Converter<Set<Appointment>, Set<AppointmentDTO>> appointmentPatientConverter = context -> {
            Set<Appointment> sourcePatientSet = context.getSource();
            Set<AppointmentDTO> destinationPatientSet = new HashSet<>();

            for (Appointment appointment : sourcePatientSet) {

                AppointmentDTO appointmentDTO = modelMapper.map(appointment, AppointmentDTO.class);
                appointmentDTO.setPatientDTO(null);

                destinationPatientSet.add(appointmentDTO);
            }

            return destinationPatientSet;
        };

        // saving mappings
        patientMap.addMapping(Patient::getAddress, PatientDTO::setAddressDTO);
        patientMap.addMappings(mapper -> mapper
                .using(appointmentPatientConverter)
                .map(Patient::getAppointmentList, PatientDTO::setAppointmentDTOList));


        /* ---------------------------------------------------------------------- */


        // TypeMap for Dentist
        TypeMap<Dentist, DentistDTO> dentistMap = modelMapper.createTypeMap(Dentist.class, DentistDTO.class);

        // Converter for AppointmentList skiping Dentist info
        Converter<Set<Appointment>, Set<AppointmentDTO>> appointmentDentistConverter = context -> {
            Set<Appointment> sourceDentistSet = context.getSource();
            Set<AppointmentDTO> destinationDentistSet = new HashSet<>();

            for (Appointment appointment : sourceDentistSet) {

                AppointmentDTO appointmentDTO = modelMapper.map(appointment, AppointmentDTO.class);
                appointmentDTO.setDentistDTO(null);

                destinationDentistSet.add(appointmentDTO);
            }

            return destinationDentistSet;
        };

        // saving map
        dentistMap.addMappings(mapper -> mapper
                .using(appointmentDentistConverter)
                .map(Dentist::getAppointmentList, DentistDTO::setAppointmentDTOList));


        /* ---------------------------------------------------------------------- */


        return modelMapper;
    }

}
