package com.irojas.microservices.cart_microservice.cartltem;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/{customerId}/cart/")
@RequiredArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    @PostMapping()
    public ResponseEntity<Integer> addItemToCart(@PathVariable("customerId") Integer customerId,@Valid @RequestBody CartItemRequest cartItemRequest) {
        return ResponseEntity.ok(cartItemService.addItemToCart(customerId, cartItemRequest));
    }
    @PutMapping()
    public ResponseEntity<Void> updateItemFromCart(@PathVariable("customerId") Integer customerId,@Valid @RequestBody CartItemRequest cartItemRequest) {
        cartItemService.updateItemFromCart(customerId, cartItemRequest);
        return ResponseEntity.accepted().build();
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> removeItemFromCart(@PathVariable("customerId") Integer customerId,@PathVariable("productId") Integer productId) {
        cartItemService.removeItemFromCart(customerId, productId);
        return ResponseEntity.accepted().build();
    }
}
