    package com.irojas.microservices.cart_microservice.product;

    import java.util.Optional;

    import com.irojas.microservices.cart_microservice.config.FeignConfig;
    import org.springframework.cloud.openfeign.FeignClient;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;

    @FeignClient(
            name = "product-microservice",
            configuration = FeignConfig.class  // ← AGREGAR ESTO
    )
    public interface ProductClient {
        @GetMapping("/api/v1/products/{id}")
        Optional<ProductResponse> getProductById(@PathVariable("id") Integer productId);
    }
