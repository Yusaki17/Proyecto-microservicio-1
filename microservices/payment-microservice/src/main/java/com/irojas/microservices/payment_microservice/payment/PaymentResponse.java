package com.irojas.microservices.payment_microservice.payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentResponse(
        Long id,
        Long customerId,
        Long cartId,
        BigDecimal amount,
        BigDecimal tax,
        BigDecimal total,
        PaymentMethod paymentMethod,
        String status,
        String transactionId,
        LocalDateTime createdAt
) {}