package com.ingan121.shop.product.dto;

// productId, name, description, price, amount

import lombok.Getter;

@Getter
public class ProductUpdateRequest {

    private String name;
    private String description;
    private double price;
    private int amount;

    public ProductUpdateRequest(String name, String description, double price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }
}
