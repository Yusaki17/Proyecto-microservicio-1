package com.irojas.microservices.cart_microservice.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.irojas.microservices.cart_microservice.config.FeignConfig;
import java.util.Optional;

@FeignClient(
        name = "customer-microservice",
        configuration = FeignConfig.class  // ← ESTO ES IMPORTANTE
)
public interface CustomerClient {

    @GetMapping("/api/v1/customers/{id}")
    Optional<CustomerResponse> getCustomerById(@PathVariable("id") Integer customerId);
}