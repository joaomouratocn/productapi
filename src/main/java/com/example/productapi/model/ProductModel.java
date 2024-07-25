package com.example.productapi.model;

import com.example.productapi.shared.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;

    private String Description;

    private Double price;

    public ProductModel() {}

    public ProductModel(Integer id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.Description = description;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductDTO toProductDto(){
        return new ProductDTO(
                this.getId(),
                this.getName(),
                this.getDescription(),
                this.getPrice()
        );
    }
}
