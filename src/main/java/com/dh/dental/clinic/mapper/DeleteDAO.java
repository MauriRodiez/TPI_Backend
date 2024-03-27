package com.dh.dental.clinic.mapper;

import com.dh.dental.clinic.dto.DTOResponse;
import com.dh.dental.clinic.repository.IGenericRepository;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


@Service
@NoArgsConstructor
public class DeleteDAO {
    public <T, E> DTOResponse<T> delete(Class<E> entityClass,
                                           IGenericRepository<E, Long> repository,
                                           Long id)
    {
        Logger LOGGER = Logger.getLogger(entityClass);

        DTOResponse<T> entityDTOResponse = new DTOResponse<>();
        String entityClassName = entityClass.getSimpleName();

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
