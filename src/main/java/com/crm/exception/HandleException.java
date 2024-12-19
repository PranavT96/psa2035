package com.crm.exception;

import com.crm.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice //Global catch block
public class HandleException {
    //To handle exceptions
    @ExceptionHandler(ResourceNotFound.class) //Defines what kind of exception it will handle
    public ResponseEntity<ErrorDetails> handleEmployeeNotFoundException(ResourceNotFound e, WebRequest request){
    //WebRequest request, sends back client info or url.
        ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(), request.getDescription(true));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class) //Defines what kind of exception it will handle
    public ResponseEntity<ErrorDetails> globalException(Exception e, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}


