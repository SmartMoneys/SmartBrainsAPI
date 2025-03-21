package br.com.wisefinances.smartbrains.exceptions;

import br.com.wisefinances.smartbrains.exceptions.dto.EntityNotFoundDTO;
import br.com.wisefinances.smartbrains.exceptions.dto.InternalServerErrorDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<EntityNotFoundDTO> notFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(EntityNotFoundDTO.entityNotFoundDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<InternalServerErrorDTO> internalServerErrorException(Exception ex) {
        InternalServerErrorDTO internalServerErrorResponseDTO = new InternalServerErrorDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                "Ocorreu um erro interno no Servidor! Por favor, tente novamente.",
                ex.getLocalizedMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(internalServerErrorResponseDTO);
    }
}