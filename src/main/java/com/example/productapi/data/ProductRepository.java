package com.example.productapi.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productapi.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer>{
    
}
