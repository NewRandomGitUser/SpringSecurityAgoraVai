package com.example.securityexample.infrastructure.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import org.xml.sax.helpers.DefaultHandler;

@ControllerAdvice
public class ControllerHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handlerResponseStatusException(final ResponseStatusException exception) {
        final var handlerDetails = new DefaultHandlerResponse(exception);
        return ResponseEntity.status(exception.getStatus()).body(handlerDetails);

    }


}
