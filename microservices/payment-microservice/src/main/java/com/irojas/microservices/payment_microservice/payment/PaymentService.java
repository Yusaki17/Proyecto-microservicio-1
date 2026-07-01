package com.irojas.microservices.payment_microservice.payment;

import com.irojas.microservices.payment_microservice.client.CartClient;
import com.irojas.microservices.payment_microservice.client.CartItem;
import com.irojas.microservices.payment_microservice.client.CartResponse;
import com.irojas.microservices.payment_microservice.client.CustomerClient;
import com.irojas.microservices.payment_microservice.client.CustomerResponse;
import com.irojas.microservices.payment_microservice.client.ProductClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final CartClient cartClient;
    private final CustomerClient customerClient;
    private final ProductClient productClient;

    public PaymentService(PaymentRepository paymentRepository,
                          CartClient cartClient,
                          CustomerClient customerClient,
                          ProductClient productClient) {
        this.paymentRepository = paymentRepository;
        this.cartClient = cartClient;
        this.customerClient = customerClient;
        this.productClient = productClient;
    }

    @Transactional
    public PaymentResponse processPayment(PaymentRequest request) {
        // 1. Obtener carrito del cliente
        CartResponse cart = cartClient.getCartByCustomerId(request.customerId());

        // 2. Obtener información del cliente
        CustomerResponse customer = customerClient.getCustomerById(request.customerId());

        // 3. Calcular totales
        BigDecimal subtotal = cart.totalPrice();
        BigDecimal tax = subtotal.multiply(new BigDecimal("0.08"));
        BigDecimal total = subtotal.add(tax);

        // 4. Crear entidad de pago
        Payment payment = Payment.builder()
                .customerId(request.customerId())
                .cartId(request.cartId())
                .amount(subtotal)
                .tax(tax)
                .total(total)
                .paymentMethod(request.paymentMethod())
                .status("PENDING")
                .transactionId(UUID.randomUUID().toString())
                .build();

        try {
            // 5. Procesar según método de pago
            switch (request.paymentMethod()) {
                case SALDO_NEXUS -> {
                    // Validar saldo suficiente
                    if (customer.saldo().compareTo(total) < 0) {
                        payment.setStatus("FAILED");
                        paymentRepository.save(payment);
                        throw new RuntimeException("Saldo insuficiente. Saldo disponible: $" + customer.saldo());
                    }
                    // Descontar saldo del cliente
                    customerClient.deductBalance(request.customerId(), total);
                }
                case CREDIT_CARD, DEBIT_CARD -> {
                    // Validar tarjeta (simulado)
                    if (request.cardNumber() == null || request.cardNumber().length() < 16) {
                        payment.setStatus("FAILED");
                        paymentRepository.save(payment);
                        throw new RuntimeException("Tarjeta inválida");
                    }
                }
                case PAYPAL -> {
                    // Integración con PayPal (simulado)
                }
            }

            // 6. Actualizar stock de productos
            for (CartItem item : cart.items()) {
                productClient.updateStock(item.productId(), item.quantity());
            }

            // 7. Limpiar carrito
            cartClient.clearCart(request.customerId());

            // 8. Marcar pago como completado
            payment.setStatus("COMPLETED");
            paymentRepository.save(payment);

            return mapToResponse(payment);

        } catch (Exception e) {
            payment.setStatus("FAILED");
            paymentRepository.save(payment);
            throw new RuntimeException("Error procesando pago: " + e.getMessage());
        }
    }

    private PaymentResponse mapToResponse(Payment payment) {
        return new PaymentResponse(
                payment.getId(),
                payment.getCustomerId(),
                payment.getCartId(),
                payment.getAmount(),
                payment.getTax(),
                payment.getTotal(),
                payment.getPaymentMethod(),
                payment.getStatus(),
                payment.getTransactionId(),
                payment.getCreatedAt()
        );
    }
}