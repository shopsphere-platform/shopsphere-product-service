package com.shopsphere.product.repository;

import com.shopsphere.product.entity.Product;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByIsFeaturedTrueOrderByRatingDesc();

    Page<Product> findByCategory(Product.Category category, Pageable pageable);

    @Query("""
        SELECT p FROM Product p
        WHERE LOWER(p.name)       LIKE LOWER(CONCAT('%',:q,'%'))
        OR    LOWER(p.collection) LIKE LOWER(CONCAT('%',:q,'%'))
        OR    LOWER(p.tagline)    LIKE LOWER(CONCAT('%',:q,'%'))
    """)
    List<Product> search(@Param("q") String query);
}
