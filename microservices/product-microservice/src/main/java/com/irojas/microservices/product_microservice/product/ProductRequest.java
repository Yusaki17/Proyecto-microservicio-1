package com.irojas.microservices.product_microservice.product;

import jakarta.validation.constraints.NotNull;

public record ProductRequest(
        Integer id,
        @NotNull(message = "Product Name cannot be null")
        String name,
        String description,
        @NotNull(message = "Price cannot be null")
        Integer price,
        String estado,
        Integer stock,
        @NotNull(message = "Category ID cannot be null")
        Integer categoryId

) {
}
