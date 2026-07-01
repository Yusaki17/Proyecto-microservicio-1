package com.irojas.microservices.payment_microservice.client;

public record CartItemResponse(
        Integer productId,
        Integer quantity
) {}