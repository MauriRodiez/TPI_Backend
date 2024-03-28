package com.dh.dental.clinic.mapper;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.dto.EntityIdentificatorDTO;
import com.dh.dental.clinic.repository.IGenericRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class CRUDMapper <T, E> {
    private Class<T> dtoClass;
    private Class<E> entityClass;
    private IGenericRepository<E, Long> repository;


    private Logger LOGGER;
    private final ModelMapper modelMapper = new ModelMapper();
    private String entityClassName;

    public CRUDMapper(Class<T> dtoClass, Class<E> entityClass, IGenericRepository<E, Long> repository) {
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
        this.repository = repository;
        this.LOGGER = Logger.getLogger(entityClass);
        this.entityClassName = entityClass.getSimpleName();
    }


    public DTOResponse<T> create(EntityIdentificatorDTO entityDTO) {
        DTOResponse<T> entityDTOResponse = new DTOResponse<>();
        try {
            E entity = modelMapper.map(entityDTO, entityClass);
            repository.save(entity);
            T entityDTOMapped = modelMapper.map(entity, dtoClass);

            entityDTOResponse.getData().add(Collections.singletonMap(entityClassName, entityDTOMapped));
            entityDTOResponse.setMessage(entityClassName + " saved successfully. {}");

            LOGGER.info(entityClassName + " saved successfully. {}");
        } catch (Exception e) {
            entityDTOResponse.setMessage("Error saving " + entityClassName + ": " + e.getMessage());
            LOGGER.error("Error saving " + entityClassName+ ": " + e.getMessage());
        }
        return entityDTOResponse;
    }


    public DTOResponse<T> readAll() {
        DTOResponse<T> entityDTOResponse = new DTOResponse<>();
        entityClassName+="s";
        try {
            List<E> entityList = repository.findAll();
            if (!entityList.isEmpty()) {
                List<T> entityDTOList = entityList.stream()
                        .map(entity -> modelMapper.map(entity, dtoClass))
                        .toList();
                entityDTOResponse.getData().add(Collections.singletonMap(entityClassName, entityDTOList));
                entityDTOResponse.setMessage("Request to see all " + entityClassName + " completed successfully: {}");
                LOGGER.info("Request to see all " + entityClassName + " completed successfully: {}");
            } else {
                entityDTOResponse.setMessage("Error: There are no registered " + entityClassName);
            }
        } catch (Exception e) {
            LOGGER.error("Error showing " + entityClassName + ": {} " + e.getMessage());
            entityDTOResponse.setMessage("Error showing " + entityClassName + ": {} " + e.getMessage());
        }
        return entityDTOResponse;
    }


    public DTOResponse<T> readById(Long id)
    {
        DTOResponse<T> entityDTOResponse = new DTOResponse<>();
        try {
            Optional<E> entityOptional = repository.findById(id);
            if (entityOptional.isPresent()) {
                E entity = entityOptional.get();
                T entityDTO = modelMapper.map(entity, dtoClass);
                entityDTOResponse.setMessage(entityClassName + " successfully found {}");
                entityDTOResponse.getData().add(Collections.singletonMap(entityClassName, entityDTO));
                LOGGER.info(entityClassName + " successfully found {}");
            } else {
                entityDTOResponse.setMessage("Error: " + entityClassName + " not found {}");
            }
        } catch (Exception e) {
            entityDTOResponse.setMessage("Error searching " + entityClassName + ": {}"  + e.getMessage());
            LOGGER.error("Error searching " + entityClassName + ": {}"  + e.getMessage());
        }
        return entityDTOResponse;
    }


    public DTOResponse<T> update(EntityIdentificatorDTO entityDTO) {
        DTOResponse<T> entityDTOResponse = new DTOResponse<>();
        try {
            Optional<E> entityOptional = repository.findById(entityDTO.getId());
            if (entityOptional.isPresent()) {
                E entity = modelMapper.map(entityDTO, entityClass);
                repository.save(entity);

                T entityDTOMapped = modelMapper.map(entity, dtoClass);

                entityDTOResponse.setMessage(entityClassName + " updated successfully: {}");
                entityDTOResponse.getData().add(Collections.singletonMap(entityClassName, entityDTOMapped));

                LOGGER.info(entityClassName + " updated successfully: {}");
            } else {
                entityDTOResponse.setMessage("Error: " + entityClassName + " not found {}");
            }
        } catch (Exception e) {
            entityDTOResponse.setMessage("Error updating " + entityClassName + ": {} " + e.getMessage());
            LOGGER.error("Error updating " + entityClassName + ": {} " + e.getMessage());
        }
        return entityDTOResponse;
    }


    public DTOResponse<T> delete(Long id) {
        DTOResponse<T> entityDTOResponse = new DTOResponse<>();
        try {
            if (repository.findById(id).isPresent()) {
                repository.deleteById(id);
                entityDTOResponse.setMessage(entityClassName + " deleted succesfully: {}");
                LOGGER.info(entityClassName + " deleted succesfully: {}");
            } else {
                entityDTOResponse.setMessage("Error: " + entityClassName + " not found: {}");
            }
        } catch (Exception e) {
            entityDTOResponse.setMessage("Error deleting " + entityClassName + " {}" + e.getMessage());
            LOGGER.error("Error deleting " + entityClassName + " {}" + e.getMessage());
        }
        return entityDTOResponse;
    }



}
