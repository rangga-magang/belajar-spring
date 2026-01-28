package com.belajarspring.payloads.requests;

public class ProductRequest {
    private String name;
    private Integer price;
    private Integer stock;

    // constructor
    public ProductRequest() {

    }

    public ProductRequest(String name, Integer price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // setter and getter
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStock() {
        return this.stock;
    }
}
