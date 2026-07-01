package com.irojas.microservices.payment_microservice.payment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record PaymentRequest(

        @NotNull(message = "El ID del cliente es obligatorio")
        @Positive(message = "El ID del cliente debe ser positivo")
        Long customerId,

        @NotNull(message = "El ID del carrito es obligatorio")
        @Positive(message = "El ID del carrito debe ser positivo")
        Long cartId,

        @NotNull(message = "El método de pago es obligatorio")
        PaymentMethod paymentMethod,

        @NotBlank(message = "El número de tarjeta es obligatorio")
        @Pattern(regexp = "^\\d{16}$", message = "El número de tarjeta debe tener 16 dígitos")
        String cardNumber,

        @NotBlank(message = "La fecha de expiración es obligatoria")
        @Pattern(regexp = "^(0[1-9]|1[0-2])/\\d{2}$", message = "Formato inválido. Use MM/AA")
        String cardExpiry,

        @NotBlank(message = "El CVV es obligatorio")
        @Pattern(regexp = "^\\d{3,4}$", message = "El CVV debe tener 3 o 4 dígitos")
        String cardCvv,

        @NotBlank(message = "El nombre del titular es obligatorio")
        @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]{3,50}$", message = "Nombre inválido (solo letras, 3-50 caracteres)")
        String cardHolderName
) {}