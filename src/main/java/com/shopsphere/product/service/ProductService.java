package com.shopsphere.product.service;

import com.shopsphere.product.entity.Product;
import com.shopsphere.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service @RequiredArgsConstructor @Slf4j
public class ProductService {

    private final ProductRepository repo;

    public Page<Product> findAll(int page, int size, String sort) {
        Sort sorting = switch (sort != null ? sort : "featured") {
            case "price_asc"  -> Sort.by("price").ascending();
            case "price_desc" -> Sort.by("price").descending();
            case "rating"     -> Sort.by("rating").descending();
            default           -> Sort.by("isFeatured").descending().and(Sort.by("rating").descending());
        };
        return repo.findAll(PageRequest.of(page, size, sorting));
    }

    public Page<Product> findByCategory(String category, int page, int size) {
        try {
            Product.Category cat = Product.Category.valueOf(category.toUpperCase());
            return repo.findByCategory(cat, PageRequest.of(page, size));
        } catch (IllegalArgumentException e) {
            return repo.findAll(PageRequest.of(page, size));
        }
    }

    public Product findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found: " + id));
    }

    public List<Product> findFeatured() {
        return repo.findByIsFeaturedTrueOrderByRatingDesc();
    }

    public List<Product> search(String query) {
        return repo.search(query);
    }

    public Product save(Product product) { return repo.save(product); }

    public void delete(Long id) { repo.deleteById(id); }

    public long count() { return repo.count(); }
}
