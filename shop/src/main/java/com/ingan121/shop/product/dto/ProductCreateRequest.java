package com.ingan121.shop.product.dto;

// name, description, price, amount

import lombok.Getter;

@Getter
public class ProductCreateRequest {

    private String name;
    private String description;
    private double price;
    private int amount;

    public ProductCreateRequest(String name, String description, double price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }
}
