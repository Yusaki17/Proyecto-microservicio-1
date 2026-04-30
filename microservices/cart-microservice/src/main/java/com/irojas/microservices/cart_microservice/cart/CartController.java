package com.irojas.microservices.cart_microservice.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/{customerId}/cart/")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping()
    public ResponseEntity<CartResponse> getCartByCustomerId(@PathVariable("customerId") Integer customerId) {
        CartResponse cartResponse = cartService.getCartByCustomerId(customerId);
        return ResponseEntity.ok(cartResponse);
    }

    @DeleteMapping()
    public ResponseEntity<Void> clearCart(@PathVariable("customerId") Integer customerId) {
        cartService.clearCart(customerId);
        return ResponseEntity.noContent().build();
    }
}
