package com.shopsphere.product.controller;

import com.shopsphere.product.entity.Product;
import com.shopsphere.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> getAll(
            @RequestParam(defaultValue = "0")  int    page,
            @RequestParam(defaultValue = "12") int    size,
            @RequestParam(required = false)    String sort,
            @RequestParam(required = false)    String category
    ) {
        if (category != null && !category.isBlank()) {
            return ResponseEntity.ok(productService.findByCategory(category, page, size));
        }
        return ResponseEntity.ok(productService.findAll(page, size, sort));
    }

    @GetMapping("/featured")
    public ResponseEntity<List<Product>> getFeatured() {
        return ResponseEntity.ok(productService.findFeatured());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> search(@RequestParam String q) {
        return ResponseEntity.ok(productService.search(q));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        return ResponseEntity.ok(Map.of("status", "product-service is running", "products", String.valueOf(productService.count())));
    }
}
