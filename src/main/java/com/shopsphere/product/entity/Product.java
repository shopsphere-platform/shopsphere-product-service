package com.shopsphere.product.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String collection;

    private String tagline;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    private String badge;
    private String movement;
    private String caseMaterial;
    private String crystal;
    private String waterResistance;
    private String diameter;
    private String powerReserve;
    private String straps;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    @Builder.Default private Double  rating        = 0.0;
    @Builder.Default private Integer reviewCount   = 0;
    @Builder.Default private Boolean inStock       = true;
    @Builder.Default private Boolean isFeatured    = false;
    @Builder.Default private Integer stockQuantity = 100;

    @Column(updatable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    public enum Category { MENS, WOMENS, UNISEX }
}
