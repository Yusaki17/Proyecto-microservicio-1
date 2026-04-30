package com.irojas.microservices.cart_microservice.cartltem;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Embeddable
public class CartItem {
    private Integer productId;
    private Integer quantity;

}
