package com.irojas.microservices.product_microservice.category;

import jakarta.validation.constraints.NotNull;

public record CategoryRequest(
        Integer id,
        @NotNull(message = "El nombre de la categoría no puede ser nulo")
        String name
) {
}
