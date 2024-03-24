package com.dh.dental.clinic.service.dao;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.dto.entityDTO.EntityIdentificatorDTO;
import com.dh.dental.clinic.repository.IGenericRepository;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
@Service
@NoArgsConstructor
public class UpdateDAO {
    private final ModelMapper modelMapper = new ModelMapper();

    public <T, E> DTOResponse<T> update(EntityIdentificatorDTO entityDTO,
                                        Class<T> dtoClass,
                                        Class<E> entityClass,
                                        IGenericRepository<E, Long> repository) {

        Logger LOGGER = Logger.getLogger(entityClass);

        E entity = modelMapper.map(entityDTO, entityClass);
        DTOResponse<T> entityDTOResponse = new DTOResponse<>();
        String entityClassName = entityClass.getSimpleName();
        try {
            Optional<E> entityOptional = repository.findById(entityDTO.getId());
            if (entityOptional.isPresent()) {
                repository.save(entity);
                entityDTOResponse.setMessage(entityClassName + " updated successfully: {}");
                T entityDTOMapped = modelMapper.map(entity, dtoClass);
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
}
