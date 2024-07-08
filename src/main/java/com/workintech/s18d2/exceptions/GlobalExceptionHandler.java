package com.workintech.s18d2.exceptions;

import com.workintech.s18d2.entity.Fruit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(PlantException.class)
    public ResponseEntity<EntityErrorResponse> handlerException(PlantException entityException){
        EntityErrorResponse error = new EntityErrorResponse(entityException.getMessage(),entityException.getHttpStatus().value());
        return new ResponseEntity<>(error,entityException.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<EntityErrorResponse> handlerException(Exception exception){
        EntityErrorResponse error = new EntityErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
