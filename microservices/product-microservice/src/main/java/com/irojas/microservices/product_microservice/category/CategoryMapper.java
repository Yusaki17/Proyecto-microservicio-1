package com.irojas.microservices.product_microservice.category;

import com.irojas.microservices.product_microservice.product.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {

    public Category toCategory(CategoryRequest request) {
        return Category.builder()
                .id(request.id())
                .name(request.name())
                .build();
    }
    public CategoryResponse toCategoryResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getProducts().stream()
                        .map(product -> new ProductResponse(
                                product.getId(),
                                product.getName(),
                                product.getDescription(),
                                product.getPrice(),
                                product.getEstado(),
                                product.getStock(),
                                product.getCategory().getId(),
                                product.getCategory().getName()
                        ))
                        .toList()
        );

    }
}
