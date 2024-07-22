package com.example.productapi.service;

import java.util.List;
import java.util.Optional;

import com.example.productapi.util.EmptyDataException;
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
            return productDataSource.getAllProducts();
        }else{
            throw new EmptyDataException();
        }
    }

    /**
     * Get productModel by ID
     * @param id id for wanted
     * @return if you find return optional with product or optional empty
     */
    public Optional<ProductModel> getProductById(Integer id){
        return productDataSource.getProductById(id);
    }

    /**
     * Insert product
     * @param product product as insert
     * @return id product
     */
    public Integer insertProduct(ProductModel product){
        return productDataSource.insertProduct(product);
    }

    /**
     * Update product
     * @param product product to update
     * @return if you find product return optional<id product> or optional empty
     */
    public Optional<Integer> updateProduct(ProductModel product){
        return productDataSource.updateProduct(product);
    }

    /**
     * Delete products
     * @param id id product for delete
     * @return id of product deleted
     */
    public Optional<Integer> deleteProduct(Integer id){
        return productDataSource.deleteProduct(id);
    }
}
