package com.example.productapi.util;

import com.example.productapi.model.ProductModel;
import com.example.productapi.shared.ProductDTO;

public class Converters {
    public static ProductDTO toProductDto(ProductModel productModel){
        return new ProductDTO(
                productModel.getId(),
                productModel.getName(),
                productModel.getDescription(),
                productModel.getPrice()
        );
    }

    public static ProductModel toProductModel(ProductDTO productDto){
        return new ProductModel(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice()
        );
    }
}
