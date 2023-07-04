package br.matc84.spring.exercicio.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.matc84.spring.exercicio.api.handlers.ExceptionResponseEntityHandler;
import br.matc84.spring.exercicio.domain.exceptions.InvoiceNotFoundException;
import br.matc84.spring.exercicio.domain.models.ApplicationErrorModel;
import br.matc84.spring.exercicio.domain.models.ErrorModel;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(InvoiceNotFoundException.class)
    public ResponseEntity<ApplicationErrorModel> handleNotFoundException(InvoiceNotFoundException ex) {
        return ExceptionResponseEntityHandler.createResponseEntityFor(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApplicationErrorModel> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ErrorModel> errors = ex.getBindingResult().getFieldErrors().stream().map(error -> new ErrorModel(error.getDefaultMessage(), error.getField(), error.getRejectedValue())).toList();
        
        return ExceptionResponseEntityHandler.createResponseEntityFor(ex, HttpStatus.BAD_REQUEST, errors);
    }
}