package com.example.productapi.service;

import java.util.List;
import java.util.Optional;

import com.example.productapi.util.exceptions.EmptyDataException;
import com.example.productapi.util.exceptions.IdNotFoundException;
import com.example.productapi.util.exceptions.InvalidInputDataException;
import com.example.productapi.util.exceptions.ProductNotFoundExecption;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productapi.data.ProductDataSource;
import com.example.productapi.model.ProductModel;

@Service
public class ProductService {
    @Autowired
    private ProductDataSource productDataSource;

    /**
     * Select all items of the list
     * @return list of ProductModel
     */
    public List<ProductModel> getAllProducts(){
        List<ProductModel> result = productDataSource.getAllProducts();
        if (result.isEmpty()){
            throw new EmptyDataException();
        }else{
            return result;
        }
    }

    /**
     * Get productModel by ID
     * @param id id for wanted
     * @return if you find return optional with product or optional empty
     */
    public Optional<ProductModel> getProductById(Integer id){
        Optional<ProductModel> result = productDataSource.getProductById(id);
        if (result.isEmpty()){
            throw new IdNotFoundException();
        }else{
            return result;
        }
    }

    /**
     * Insert product
     * @param product product as insert
     * @return id product
     */
    public Integer insertProduct(ProductModel product){
        if (product.getName() == null || product.getDescription() == null || product.getPrice() == null) {
            throw new InvalidInputDataException();
        }else{
            return productDataSource.insertProduct(product);
        }
    }

    /**
     * Update product
     * @param product product to update
     * @return if you find product return optional<id product> or optional empty
     */
    public Integer updateProduct(Integer productId, ProductModel product){
        Optional<ProductModel> result = productDataSource.getProductById(productId);
        if (result.isEmpty()){
            throw new IdNotFoundException();
        }else{
            if (product.getName() == null || product.getDescription() == null || product.getPrice() == null) {
                throw new InvalidInputDataException();
            }else{
                return productDataSource.updateProduct(productId, product);
            }
        }
    }

    /**
     * Delete products
     * @param id id product for delete
     * @return id of product deleted
     */
    public Optional<Integer> deleteProduct(Integer id){
        Optional<ProductModel> result = productDataSource.getProductById(id);
        if (result.isEmpty()){
            throw new IdNotFoundException();
        }else{
            return productDataSource.deleteProduct(id);
        }
    }
}
