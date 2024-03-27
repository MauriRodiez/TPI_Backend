package com.dh.dental.clinic.mapper;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.repository.IGenericRepository;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ReadDAO {

    private final ModelMapper modelMapper = new ModelMapper();

    public <T, E> DTOResponse<T> readAll(Class<T> dtoClass,
                                         Class<E> entityClass,
                                         IGenericRepository<E, Long> repository)
    {
        Logger LOGGER = Logger.getLogger(entityClass);

        DTOResponse<T> entityDTOResponse = new DTOResponse<>();
        String entityClassName = entityClass.getSimpleName() + "s";
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


    public <T, E> DTOResponse<T> readById(Class<T> dtoClass,
                                        Class<E> entityClass,
                                        IGenericRepository<E, Long> repository,
                                        Long id)
    {
        Logger LOGGER = Logger.getLogger(entityClass);

        DTOResponse<T> entityDTOResponse = new DTOResponse<>();
        String entityClassName = entityClass.getSimpleName();

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
}
