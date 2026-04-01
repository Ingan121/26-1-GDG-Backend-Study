package com.ingan121.shop.product.dto;

// productId, name, description, price, amount

import lombok.Getter;

@Getter
public class ProductCreateRequest {

    private String productId;
    private String name;
    private String description;
    private double price;
    private int amount;

    public ProductCreateRequest(String productId, String name, String description, double price, int amount) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }
}
