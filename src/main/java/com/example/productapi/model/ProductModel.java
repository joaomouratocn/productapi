package com.example.productapi.model;

public class ProductModel {
    //region atributtes
    private Integer id;
    
    private String name;

    private String Description;

    private Double price;
    //#endregion

    //#region
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
    //#endregion
}
