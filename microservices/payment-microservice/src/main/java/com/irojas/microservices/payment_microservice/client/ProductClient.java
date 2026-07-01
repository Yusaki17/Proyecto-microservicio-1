package com.irojas.microservices.payment_microservice.client;

import com.irojas.microservices.payment_microservice.config.FeignConfig;  // ← AGREGAR
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product-microservice", configuration = FeignConfig.class)  // ← CAMBIAR
public interface ProductClient {
    @PatchMapping("/api/v1/products/{id}/stock")
    void updateStock(@PathVariable("id") Long id, @RequestParam("quantity") Integer quantity);
}