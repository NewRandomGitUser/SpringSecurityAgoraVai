package com.example.securityexample.infrastructure.controller.request;

import lombok.Getter;

@Getter
public class RegistrationRequest {
    private String login;
    private String password;
    private String fullName;
}
