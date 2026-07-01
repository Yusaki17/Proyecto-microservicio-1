package com.irojas.microservices.payment_microservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "PRODUCT-MICROSERVICE")
public interface ProductClient {

    @PatchMapping("/api/v1/products/{id}/stock")
    void updateStock(@PathVariable("id") Long id, @RequestParam("quantity") Integer quantity);
}