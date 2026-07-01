package com.irojas.microservices.payment_microservice.client;

import java.math.BigDecimal;

public record CustomerResponse(
        Long id,
        String username,
        String email,
        String nombre,
        BigDecimal saldo,
        String estado
) {}
