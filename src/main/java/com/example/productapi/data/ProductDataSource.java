package com.example.productapi.data;

import java.util.List;
import java.util.Optional;

import com.example.productapi.model.ProductModel;

public class ProductDataSource {
    private List<ProductModel> dataSource;
    private Integer countId = 0;

    /**
     * Select all itens of list
     * @return list of ProductModel
     */
    public List<ProductModel> getAllProducts(){
        return dataSource;
    }

    /**
     * Get productModel by ID
     * @param id id for wanted
     * @return if find return optinal with product or optinal empty
     */
    public Optional<ProductModel> getProductById(Integer id){
        for (ProductModel productModel : dataSource) {
            if (productModel.getId() == id) {
                return Optional.of(productModel);
            }
        }
        return Optional.empty();
    }

    /**
     * Insert product
     * @param productModel produt as insert
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
     * @return if find product return optional<id product> or optional empty
     */
    public Optional<Integer> updateProduct(ProductModel product){
        Integer index =  dataSource.indexOf(product);
        if (index == -1) {
            return Optional.empty();
        }else{
            dataSource.set(index, product);
            return Optional.of(product.getId());
        }
    }

    /**
     * Delete products
     * @param product product for delete
     * @return id of product deleted
     */
    public Optional<Integer> deleteProduct(ProductModel product){
        if (dataSource.indexOf(product) == -1) {
            return Optional.empty();
        }else{
            dataSource.remove(product);
            return Optional.of(product.getId());
        }
    }
}
