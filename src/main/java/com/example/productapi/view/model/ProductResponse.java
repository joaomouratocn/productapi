package com.example.productapi.view.model;

import com.example.productapi.shared.ProductDTO;

//modelar aqui modelo de reposta
public class ProductResponse {
    private Integer id;

    private String name;

    private String Description;

    private Double price;

    public ProductResponse(Integer id, String name, String description, Double price) {
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
}
