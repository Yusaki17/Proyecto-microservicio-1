package com.irojas.microservices.product_microservice.product;

import com.irojas.microservices.product_microservice.category.Category;
import org.springframework.stereotype.Service;

@Service

public class ProductMapper {

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getEstado(),
                product.getStock(),
                product.getCategory().getId(),
                product.getCategory().getName()
        );
    }
    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .estado(request.estado())
                .stock(request.stock())
                .category(Category.builder().id(request.categoryId()).build())
                .build();
    }
}
