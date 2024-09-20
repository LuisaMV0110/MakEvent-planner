package com.mindhub.event_planner.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectNotFound.class)
    public ResponseEntity<String> ObjectNotFoundExceptionHandler( ObjectNotFound objectNotFound){
        return ResponseEntity.badRequest().body(objectNotFound.getMessage());
    }
}
