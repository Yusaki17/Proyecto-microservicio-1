package com.irojas.microservices.product_microservice.category;


import com.irojas.microservices.product_microservice.product.ProductResponse;

import java.util.List;

public record CategoryResponse(
        Integer id,
        String name,
        List<ProductResponse> products
) {

}
