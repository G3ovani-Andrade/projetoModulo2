package com.MedicineInc.LABMedication.exceptions;

import com.MedicineInc.LABMedication.dto.validacao.ErroValidacaoDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class TratadorDeExcessoes {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> tratarEntityNotFound(EntityNotFoundException e){
        return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity tratarExcessaoEnum(IllegalArgumentException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroValidacaoDTO>> tratarParametroInvalido(MethodArgumentNotValidException e){
        List<FieldError> errors = e.getFieldErrors();
        List<ErroValidacaoDTO> errosDTO = new ArrayList<>();
        for(FieldError erro : errors){
            errosDTO.add(new ErroValidacaoDTO(erro));
        }
        return new ResponseEntity<>(errosDTO,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> tratarConflitoCpf(DataIntegrityViolationException e){
        return new ResponseEntity<>("Cpf já cadastrado",HttpStatus.CONFLICT);
    }
}
