package com.irojas.microservices.auth_microservice.auth;

public record AuthRequest(
        String email,
        String password
) {}