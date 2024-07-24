package com.example.productapi.service;

import com.example.productapi.data.ProductRepository;
import com.example.productapi.model.ProductModel;
import com.example.productapi.shared.ProductDTO;
import com.example.productapi.util.Converters;
import com.example.productapi.util.exceptions.EmptyDataException;
import com.example.productapi.util.exceptions.IdNotFoundException;
import com.example.productapi.util.exceptions.InvalidInputDataException;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.example.productapi.util.Converters.toProductDto;
import static com.example.productapi.util.Converters.toProductModel;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager entityManager;

    /**
     * Select all items of the list
     *
     * @return list of ProductModel
     */
    public List<ProductDTO> getAllProducts() {
        List<ProductModel> result = productRepository.findAll();
        if (result.isEmpty()) {
            throw new EmptyDataException();
        } else {
            return result.stream()
                    .map(Converters::toProductDto)
                    .toList();
        }
    }

    /**
     * Get productModel by ID
     *
     * @param id id for wanted
     * @return if you find return optional with product or optional empty
     */
    public ProductDTO getProductById(Integer id) {
        Optional<ProductModel> result = productRepository.findById(id);
        if (result.isEmpty()) {
            throw new IdNotFoundException();
        } else {
            return toProductDto(result.get());
        }
    }

    /**
     * Insert product
     *
     * @param product product as insert
     * @return id product
     */
    public ProductDTO insertProduct(ProductDTO product) {
        if (product.getName() == null || product.getDescription() == null || product.getPrice() == null) {
            throw new InvalidInputDataException();
        } else {
            ProductModel converted = toProductModel(product);
            return toProductDto(productRepository.save(converted));
        }
    }

    /**
     * Update product
     *
     * @param product product to update
     */
    public ProductDTO updateProduct(Integer productId, ProductDTO product) {
        product.setId(productId);
        ProductModel converted = toProductModel(product);
        return toProductDto(productRepository.save(converted));
    }

    /**
     * Delete products
     *
     * @param id id product for delete
     */
    public void deleteProduct(Integer id) {
        Optional<ProductModel> result = productRepository.findById(id);
        if (result.isEmpty()) {
            throw new IdNotFoundException();
        } else {
            productRepository.delete(result.get());
        }
    }
}
