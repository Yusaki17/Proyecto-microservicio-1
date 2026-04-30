package com.irojas.microservices.product_microservice.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping()
    public ResponseEntity<Integer> createProduct(@Valid @RequestBody ProductRequest product) {
        return ResponseEntity.ok(service.createProduct(product));
    }

    @GetMapping()
    public List<ProductResponse> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/category/{id}")
    public List<ProductResponse> getProductsByCategoryId(@PathVariable Integer id) {
        return service.getProductsByCategoryId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @PutMapping()
    public ResponseEntity<Integer> updateProduct(@Valid @RequestBody ProductRequest product) {
        return ResponseEntity.ok(service.updateProduct(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        service.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/purchase")
    public ResponseEntity<Void> purchaseProduct(@Valid @RequestBody List<ProductQuantityRequest> request) {
        service.purchaseProduct(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/restock")
    public ResponseEntity<Void> updateProductStock(@Valid @RequestBody List<ProductQuantityRequest> request) {
        service.restockProduct(request);
        return ResponseEntity.ok().build();
    }

}