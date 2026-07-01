package com.irojas.microservices.payment_microservice.client;

import java.math.BigDecimal;
import java.util.List;

public record CartResponse(
        Long id,
        Long customerId,
        List<CartItem> items,
        BigDecimal totalPrice
) {}
