package com.example.staffmanagement.Exception;


import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
        Error failed = new Error(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(failed, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerGlobalException(Exception e, WebRequest request) {
        Error failed = new Error(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity(failed, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @org.springframework.web.bind.annotation.ExceptionHandler(APIException.class)
//    public ResponseEntity<?> handleAPIException(APIException exception, WebRequest request) {
//        Error failed = new Error(new Date(), exception.getMessage(), request.getDescription(false));
//        return new ResponseEntity(failed, HttpStatus.NOT_FOUND);
//    }

}
