package com.irojas.microservices.payment_microservice.client;

import com.irojas.microservices.payment_microservice.payment.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cart-microservice", configuration = FeignClientsConfiguration.class)
public interface CartClient {

    @GetMapping("/api/v1/{customerId}/cart/")
    CartResponse getCartByCustomerId(@PathVariable("customerId") Long customerId);

    @DeleteMapping("/api/v1/{customerId}/cart/")
    void clearCart(@PathVariable("customerId") Long customerId);
}