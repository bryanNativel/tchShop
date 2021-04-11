package com.example.springTdBeuh.controller;

import com.example.springTdBeuh.model.Product;
import com.example.springTdBeuh.repo.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    List<Product> all() {
        return repository.findAll();
    }

    // end::get-aggregate-root[]
    @PostMapping("/products")
    Product newProduct(@RequestBody Product newProduct) {
        return repository.save(newProduct);
    }

    // Single item
    @GetMapping("/products/{id}")
    Optional<Product> one(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/products/{id}")
    Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {

        return repository.findById(id)
                .map(user -> {
                    user.setSerialNumber(newProduct.getSerialNumber());
                    user.setPrice(newProduct.getPrice());
                    user.setUnit(newProduct.getUnit());
                    user.setQuantityInStock(newProduct.getQuantityInStock());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });
    }

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }

}