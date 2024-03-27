package com.dh.dental.clinic.mapper;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.dto.EntityIdentificatorDTO;
import com.dh.dental.clinic.repository.IGenericRepository;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@NoArgsConstructor
public class CreateDAO {
    private final ModelMapper modelMapper = new ModelMapper();
    public <T, E> DTOResponse<T> create(EntityIdentificatorDTO entityDTO,
                                        Class<T> dtoClass,
                                        Class<E> entityClass,
                                        IGenericRepository<E, Long> repository)
    {
        Logger LOGGER = Logger.getLogger(entityClass);
        DTOResponse<T> entityDTOResponse = new DTOResponse<>();
        String entityClassName = entityClass.getSimpleName();
        try {
            E entity = modelMapper.map(entityDTO, entityClass);
            repository.save(entity);
            T entityDTOMapped = modelMapper.map(entity, dtoClass);

            entityDTOResponse.getData().add(Collections.singletonMap(entityClassName, entityDTOMapped));
            entityDTOResponse.setMessage(entityClassName + " saved successfully");
            LOGGER.info(entityClassName + " saved successfully");
        } catch (Exception e) {
            entityDTOResponse.setMessage("Error saving " + entityClassName + ": " + e.getMessage());
            LOGGER.error("Error saving " + entityClassName+ ": " + e.getMessage());
        }
        return entityDTOResponse;
    }
}