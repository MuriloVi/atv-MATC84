package br.matc84.spring.exercicio.api.handlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.matc84.spring.exercicio.domain.models.ApplicationErrorModel;
import br.matc84.spring.exercicio.domain.models.ErrorModel;

public class ExceptionResponseEntityHandler {
    private static final String CLIENT_RESPONSE_DEFAULT_MESSAGE = "Something went wrong. Please contact system administrators!";
    private ExceptionResponseEntityHandler() { }

    public static ResponseEntity<ApplicationErrorModel> createResponseEntityFor(Exception exception, HttpStatus status) {
        ApplicationErrorModel error = ApplicationErrorModel.ApplicationErrorModelBuilder.anApplicationErrorModelBuilder()
            .withStatusCode(status.value())
            .withStatusDescription(status.getReasonPhrase())
            .withDeveloperMessage(exception.getMessage())
            .withClientMessage(CLIENT_RESPONSE_DEFAULT_MESSAGE)
            .build();

        return new ResponseEntity<>(error, status);
    }

    public static ResponseEntity<ApplicationErrorModel> createResponseEntityFor(Exception exception, HttpStatus status, List<ErrorModel> errors) {
        ApplicationErrorModel error = ApplicationErrorModel.ApplicationErrorModelBuilder.anApplicationErrorModelBuilder()
            .withStatusCode(status.value())
            .withStatusDescription(status.getReasonPhrase())
            .withDeveloperMessage(exception.getMessage())
            .withClientMessage(CLIENT_RESPONSE_DEFAULT_MESSAGE)
            .withErrors(errors)
            .build();

        return new ResponseEntity<>(error, status);
    }
}