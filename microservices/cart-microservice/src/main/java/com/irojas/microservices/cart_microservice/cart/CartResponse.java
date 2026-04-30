package com.irojas.microservices.cart_microservice.cart;

import com.irojas.microservices.cart_microservice.cartltem.CartItemResponse;
import java.util.List;
public record CartResponse(
        Integer id,
        Integer customerId,
        List<CartItemResponse> cartItems
) {
}
