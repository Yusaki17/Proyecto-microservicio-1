package com.irojas.microservices.cart_microservice.product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductClientService {

    private final ProductClient productClient; // ← se inyecta al Feign Client


    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackProducto")
    @Retry(name = "productService")
    @RateLimiter(name = "productService")
    public Optional<ProductResponse> getProductById(Integer productId) {
        log.info("Consultando producto {} al servicio externo", productId);
        return productClient.getProductById(productId); // ← delega al Feign
    }


    public Optional<ProductResponse> fallbackProducto(Integer productId, Exception ex) {
        log.warn("Fallback activado para producto {}. Error: {}", productId, ex.getMessage());
        return Optional.empty();
    }
}
