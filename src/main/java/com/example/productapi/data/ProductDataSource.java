package com.example.productapi.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.productapi.model.ProductModel;

@Repository
public class ProductDataSource {
    private final List<ProductModel> dataSource = new ArrayList<>();
    private Integer countId = 0;

    /**
     * Select all items of the list
     * @return list of ProductModel
     */
    public List<ProductModel> getAllProducts(){
        return dataSource;
    }

    /**
     * Get productModel by ID
     * @param id id for wanted
     * @return if you find return optional with product or optional empty
     */
    public Optional<ProductModel> getProductById(Integer id){
        for (ProductModel productModel : dataSource) {
            if (Objects.equals(productModel.getId(), id)) {
                return Optional.of(productModel);
            }
        }
        return Optional.empty();
    }

    /**
     * Insert product
     * @param product product as insert
     * @return id product
     */
    public Integer insertProduct(ProductModel product){
        countId++;
        product.setId(countId);
        return countId;
    }

    /**
     * Update product
     * @param product product to update
     * @return if you find product return optional<id product> or optional empty
     */
    public Optional<Integer> updateProduct(ProductModel product){
        int index =  dataSource.indexOf(product);
        if (index == -1) {
            return Optional.empty();
        }else{
            dataSource.set(index, product);
            return Optional.of(product.getId());
        }
    }

    /**
     * Delete products
     * @param id id product for delete
     * @return id of product deleted
     */
    public Optional<Integer> deleteProduct(Integer id){
        Optional<ProductModel> result = getProductById(id);
        if (result.isEmpty()) {
            return Optional.empty();
        }else{
            dataSource.remove(result.get());
            return Optional.of(id);
        }
    }
}
