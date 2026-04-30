package com.irojas.microservices.customer_microservice.customer;

import lombok.Builder;

import java.util.Date;
@Builder
public record CustomerResponse(
        Integer id,
        String username,   // Sugerencia: usa 'username' para ser consistente con tu clase Customer
        String email,
        String password,
        String nombre,
        String pais,
        Integer saldo,
        Date fecha_registro,
        String estado
) {
}
