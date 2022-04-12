package com.enessimsek.urlshortener.urlshortener.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(UrlShortenerNotFoundException.class)
    public ResponseEntity<Object> handleAllExceptions(UrlShortenerNotFoundException e, WebRequest webRequest){
        Date errorDate=new Date();
        String message=e.getMessage();
        String detail=webRequest.getDescription(false);

        ExceptionResponse exceptionResponse=new ExceptionResponse(errorDate,message,detail);

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<Object> handleAllExceptions(Exception e,WebRequest webRequest){
        Date errorDate=new Date();
        String message=e.getMessage();
        String detail=webRequest.getDescription(false);

        ExceptionResponse exceptionResponse=new ExceptionResponse(errorDate,message,detail);
        return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Date errorDate = new Date();
        String message = "Validation failed!";
        String description = ex.getBindingResult().toString();

        ExceptionResponse exceptionResponse = new ExceptionResponse(errorDate, message, description);

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
