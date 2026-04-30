package com.irojas.microservices.product_microservice.product;

import com.irojas.microservices.product_microservice.category.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private Integer price;
    private String estado;
    private Integer stock;
    private Date fecha_creacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @PrePersist
    public void prePersist() {
        if (stock == null) {
            stock = 0; // Valor predeterminado para stock si no se proporciona
        }
    }
}
