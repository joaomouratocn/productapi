package com.example.productapi.shared;

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
}
