package com.example.productapi.service;

import java.util.List;
import java.util.Optional;

import com.example.productapi.util.exceptions.EmptyDataException;
import com.example.productapi.util.exceptions.IdNotFoundException;
import com.example.productapi.util.exceptions.InvalidInputDataException;

import jakarta.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.productapi.data.ProductRepository;
import com.example.productapi.model.ProductModel;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager entityManager;

    /**
     * Select all items of the list
     * @return list of ProductModel
     */
    public List<ProductModel> getAllProducts(){
        List<ProductModel> result = productRepository.findAll();
        if (result.isEmpty()){
            throw new EmptyDataException();
        }else{
            return productRepository.findAll();
        }
    }

    /**
     * Get productModel by ID
     * @param id id for wanted
     * @return if you find return optional with product or optional empty
     */
    public ProductModel getProductById(Integer id){
        Optional<ProductModel> result = productRepository.findById(id);
        if (result.isPresent()){
            throw new IdNotFoundException();
        }else{
            return result.get();
        }
    }

    /**
     * Insert product
     * @param product product as insert
     * @return id product
     */
    public ProductModel insertProduct(ProductModel product){
        if (product.getName() == null || product.getDescription() == null || product.getPrice() == null) {
            throw new InvalidInputDataException();
        }else{
            return productRepository.save(product);
        }
    }

    /**
     * Update product
     * @param product product to update
     * @return if you find product return optional<id product> or optional empty
     */
    public void updateProduct(Integer productId, ProductModel product){
        ProductModel result = entityManager.find(ProductModel.class, productId);
        if (result == null){
            throw new IdNotFoundException();
        }else{
            if (product.getName() == null || product.getDescription() == null || product.getPrice() == null) {
                throw new InvalidInputDataException();
            }else{
                result.setName(product.getName());
                result.setDescription(product.getDescription());
                result.setPrice(product.getPrice());
            }
        }
    }

    /**
     * Delete products
     * @param id id product for delete
     * @return id of product deleted
     */
    public void deleteProduct(Integer id){
        Optional<ProductModel> result = productRepository.findById(id);
        if (result.isEmpty()){
            throw new IdNotFoundException();
        }else{
            productRepository.delete(result.get());
        }
    }
}
