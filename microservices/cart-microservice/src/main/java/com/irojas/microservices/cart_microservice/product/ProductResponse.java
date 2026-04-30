package com.irojas.microservices.cart_microservice.product;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        Integer price,
        String estado,
        Integer stock,
        Integer categoryId,
        String categoryName
) {
}
