package com.example.securityexample.infrastructure.controller.handler;

import org.springframework.web.server.ResponseStatusException;

public class DefaultHandlerResponse {

    private final String message;
    private final String reason;
    private final int statusCode;
    private final String statusName;
    private final String responseHeaders;

    public DefaultHandlerResponse(final ResponseStatusException responseStatusException) {
        this.message = responseStatusException.getMessage();
        this.reason = responseStatusException.getReason();
        this.statusCode = responseStatusException.getStatus().value();
        this.statusName = responseStatusException.getStatus().name();
        this.responseHeaders = responseStatusException.getResponseHeaders().toString();
    }
}
