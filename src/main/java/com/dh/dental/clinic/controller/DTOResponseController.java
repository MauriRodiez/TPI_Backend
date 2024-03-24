package com.dh.dental.clinic.controller;

import com.dh.dental.clinic.dto.DTOResponse;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
public class DTOResponseController {
    public ResponseEntity<?> getHttpResponse(DTOResponse<?> dtoResponse) {
        if (dtoResponse.getMessage().toLowerCase().contains("error")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(dtoResponse);
        } else {
            return ResponseEntity.ok(dtoResponse);
        }
    }
}
