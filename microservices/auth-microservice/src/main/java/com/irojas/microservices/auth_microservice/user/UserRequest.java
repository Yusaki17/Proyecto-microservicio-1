package com.irojas.microservices.auth_microservice.user;

public record UserRequest(
        String username,
        String email,
        String password,
        Role role
) {}