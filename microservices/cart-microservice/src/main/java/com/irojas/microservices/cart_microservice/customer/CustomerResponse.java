package com.irojas.microservices.cart_microservice.customer;

import java.util.Date;

public record CustomerResponse(
        Integer id,
        String username,
        String email,
        String password,
        String nombre,
        String pais,
        Integer saldo,
        Date    fecha_registro,
        String estado
) {
}
