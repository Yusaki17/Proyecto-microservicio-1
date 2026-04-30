package com.irojas.microservices.cart_microservice.cart;
import java.util.ArrayList;
import java.util.List;

import com.irojas.microservices.cart_microservice.cartltem.CartItem;
import com.irojas.microservices.cart_microservice.cartltem.CartItemResponse;
import org.springframework.stereotype.Service;
@Service
public class CartMapper {
    public CartResponse toCartResponse(Cart cart) {

        List<CartItemResponse> cartItemResponses = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            cartItemResponses.add(new CartItemResponse(
                    item.getProductId(),
                    item.getQuantity()
            ));
        }

        return new CartResponse( cart.getId() , cart.getCustomerId(), cartItemResponses);
    }
}
