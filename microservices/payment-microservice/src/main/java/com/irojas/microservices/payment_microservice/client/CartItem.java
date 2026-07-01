package com.irojas.microservices.payment_microservice.client;

import java.math.BigDecimal;

public record CartItem(
        Long productId,
        Integer quantity,
        BigDecimal price
) {}
