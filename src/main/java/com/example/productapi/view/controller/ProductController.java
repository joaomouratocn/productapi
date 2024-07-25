package com.example.productapi.view.controller;

import com.example.productapi.service.ProductService;
import com.example.productapi.shared.ProductDTO;
import com.example.productapi.view.model.ProductRequest;
import com.example.productapi.view.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> allProducts = productService.getAllProducts()
                .stream()
                .map(ProductDTO::toProductResponse)
                .toList();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }


    /**
     * Get productModel by ID
     *
     * @param id id for wanted
     * @return if you find return optional with product or optional empty
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Integer id) {
        ProductResponse productResponse = productService.getProductById(id).toProductResponse();
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    /**
     * Insert product
     *
     * @param product product as insert
     * @return id product
     */
    @PostMapping
    public ResponseEntity<ProductResponse> insertProduct(@RequestBody ProductRequest product) {
        ProductResponse productResponse = productService.insertProduct(product.toProductDto()).toProductResponse();
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    /**
     * Update product
     *
     * @param product product to update
     */
    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Integer productId, @RequestBody ProductRequest product) {
        ProductResponse productResponse = productService.updateProduct(productId, product.toProductDto()).toProductResponse();
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    /**
     * Delete products
     *
     * @param productId id of product for delete
     */
    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
