package com.dh.dental.clinic.mapper;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.dto.EntityIdentificatorDTO;
import com.dh.dental.clinic.exceptions.ResourceNotFoundException;
import com.dh.dental.clinic.repository.IGenericRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
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
    private String entityClassNamePlural;

    public CRUDMapper(Class<T> dtoClass, Class<E> entityClass, IGenericRepository<E, Long> repository) {
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
        this.repository = repository;
        this.LOGGER = Logger.getLogger(entityClass);
        this.entityClassName = entityClass.getSimpleName();
        this.entityClassNamePlural = entityClassName + "s";
    }


    public DTOResponse<T> create(EntityIdentificatorDTO entityDTO) {

        DTOResponse<T> entityDTOResponse = new DTOResponse<>();

        E entity = modelMapper.map(entityDTO, entityClass);
        repository.save(entity);
        T entityDTOMapped = modelMapper.map(entity, dtoClass);

        entityDTOResponse.setStatusCode(HttpStatus.OK.value());
        entityDTOResponse.setMessage(entityClassName + " saved successfully. {}");
        entityDTOResponse.getData().add(Collections.singletonMap(entityClassName, entityDTOMapped));

        LOGGER.info(entityClassName + " saved successfully. {}");

        return entityDTOResponse;
    }


    public DTOResponse<T> readAll() {

        DTOResponse<T> entityDTOResponse = new DTOResponse<>();
        List<E> entityList = repository.findAll();

        if (!entityList.isEmpty()) {

            List<T> entityDTOList = entityList.stream()
                    .map(entity -> modelMapper.map(entity, dtoClass))
                    .toList();

            entityDTOResponse.setStatusCode(HttpStatus.OK.value());
            entityDTOResponse.setMessage("Request to see all " + entityClassNamePlural + " completed successfully: {}");
            entityDTOResponse.getData().add(Collections.singletonMap(entityClassNamePlural, entityDTOList));

            LOGGER.info("Request to see all " + entityClassNamePlural + " completed successfully: {}");

        } else {
            throw new ResourceNotFoundException(entityClassNamePlural);
        }

        return entityDTOResponse;
    }


    public DTOResponse<T> readById(Long id) {

        DTOResponse<T> entityDTOResponse = new DTOResponse<>();
        Optional<E> entityOptional = repository.findById(id);

        if (entityOptional.isPresent()) {

            E entity = entityOptional.get();
            T entityDTO = modelMapper.map(entity, dtoClass);

            entityDTOResponse.setStatusCode(HttpStatus.OK.value());
            entityDTOResponse.setMessage(entityClassName + " successfully found {}");
            entityDTOResponse.getData().add(Collections.singletonMap(entityClassName, entityDTO));

            LOGGER.info(entityClassName + " with id " + id.toString() + " successfully found.");

        } else {
            throw new ResourceNotFoundException(entityClassName);
        }

        return entityDTOResponse;
    }


    public DTOResponse<T> update(EntityIdentificatorDTO entityDTO) {

        DTOResponse<T> entityDTOResponse = new DTOResponse<>();
        Optional<E> entityOptional = repository.findById(entityDTO.getId());

        if (entityOptional.isPresent()) {

            E entity = modelMapper.map(entityDTO, entityClass);
            repository.save(entity);

            T entityDTOMapped = modelMapper.map(entity, dtoClass);

            entityDTOResponse.setStatusCode(HttpStatus.OK.value());
            entityDTOResponse.setMessage(entityClassName + " updated successfully: {}");
            entityDTOResponse.getData().add(Collections.singletonMap(entityClassName, entityDTOMapped));

            LOGGER.info(entityClassName + " updated successfully: {}");

        } else {
            throw new ResourceNotFoundException(entityClassName);
        }

        return entityDTOResponse;
    }


    public DTOResponse<T> delete(Long id) {

        DTOResponse<T> entityDTOResponse = new DTOResponse<>();
        Optional<E> deletedEntity = repository.findById(id);

        if (deletedEntity.isPresent()) {

            T entityDTOMapped = modelMapper.map(deletedEntity.get(), dtoClass);

            repository.deleteById(id);

            entityDTOResponse.setStatusCode(HttpStatus.OK.value());
            entityDTOResponse.setMessage(entityClassName + " deleted succesfully: {}");
            entityDTOResponse.getData().add(Collections.singletonMap(entityClassName, entityDTOMapped));

            LOGGER.info(entityClassName + " with id " + id.toString() + " deleted succesfully: {}");

        } else {
            throw new ResourceNotFoundException(entityClassName);
        }

        return entityDTOResponse;
    }


}
