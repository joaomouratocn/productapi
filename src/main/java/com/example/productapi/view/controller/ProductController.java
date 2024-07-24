package com.example.productapi.view.controller;

import com.example.productapi.model.ProductModel;
import com.example.productapi.service.ProductService;
import com.example.productapi.shared.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;


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
    public ProductModel getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    /**
     * Insert product
     *
     * @param product product as insert
     * @return id product
     */
    @PostMapping
    public ProductModel insertProduct(@RequestBody ProductModel product) {
        return productService.insertProduct(product);
    }

    /**
     * Update product
     *
     * @param product product to update
     */
    @PutMapping("/{productId}")
    public ProductDTO updateProduct(@PathVariable Integer productId, @RequestBody ProductModel product) {
        productService.updateProduct(productId, product);
    }

    /**
     * Delete products
     *
     * @param productId id of product for delete
     */
    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
    }
}
