package com.irojas.microservices.payment_microservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@FeignClient(name = "CUSTOMER-MICROSERVICE")
public interface CustomerClient {

    @GetMapping("/api/v1/customers/{id}")
    CustomerResponse getCustomerById(@PathVariable("id") Long id);

    @PatchMapping("/api/v1/customers/{id}/balance")
    void deductBalance(@PathVariable("id") Long id, @RequestParam("amount") BigDecimal amount);
}
