package com.example.productapi.shared;

import com.example.productapi.model.ProductModel;
import com.example.productapi.view.model.ProductResponse;

//objeto que sera convertido para Entity e vice e versa
public class ProductDTO {
    private Integer id;

    private String name;

    private String Description;

    private Double price;

    public ProductDTO(Integer id, String name, String description, Double price) {
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

    public ProductModel toProductModel(){
        return new ProductModel(
                this.getId(),
                this.getName(),
                this.getDescription(),
                this.getPrice()
        );
    }

    public ProductResponse toProductResponse(){
        return new ProductResponse(
                this.getId(),
                this.getName(),
                this.getDescription(),
                this.getPrice()
        );
    }
}
