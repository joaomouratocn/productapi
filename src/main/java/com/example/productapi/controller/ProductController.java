package com.example.productapi.controller;

import com.example.productapi.model.ProductModel;
import com.example.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * Select all items of the list
     *
     * @return list of ProductModel
     */
    @GetMapping
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Get productModel by ID
     *
     * @param id id for wanted
     * @return if you find return optional with product or optional empty
     */
    @GetMapping("/{id}")
    public Optional<ProductModel> getProductById(Integer id) {
        return productService.getProductById(id);
    }

    /**
     * Insert product
     *
     * @param product product as insert
     * @return id product
     */
    @PostMapping
    public Integer insertProduct(@RequestBody ProductModel product) {
        return productService.insertProduct(product);
    }

    /**
     * Update product
     *
     * @param product product to update
     * @return if you find product return optional<id product> or optional empty
     */
    @PutMapping("/{productId}")
    public Integer updateProduct(@PathVariable Integer productId, @RequestBody ProductModel product) {
        return productService.updateProduct(productId, product);
    }

    /**
     * Delete products
     *
     * @param id id of product for delete
     * @return id of product deleted
     */
    @DeleteMapping("/{productId}")
    public Optional<Integer> deleteProduct(@PathVariable Integer productId) {
        return productService.deleteProduct(productId);
    }
}
