package com.example.securityexample.infrastructure.controller.response;

import lombok.Builder;

@Builder
public class UserResponse {

    private String login;
    private String fullName;
}
