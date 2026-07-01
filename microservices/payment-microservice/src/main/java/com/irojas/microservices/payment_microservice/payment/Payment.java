package com.irojas.microservices.payment_microservice.payment;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private Long cartId;
    private BigDecimal amount;
    private BigDecimal tax;
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private String status; // PENDING, COMPLETED, FAILED, REFUNDED
    private String transactionId;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (createdAt == null) createdAt = LocalDateTime.now();
        if (status == null) status = "PENDING";
    }
}