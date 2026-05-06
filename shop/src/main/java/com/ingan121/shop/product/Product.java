package com.ingan121.shop.product;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    // 상품 고유 식별자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    // 상품명
    @Column(name = "product_name", length = 100)
    private String name;

    // 상품 설명
    @Column(name = "product_desc", length = 255)
    private String description;

    // 가격
    @Column(name = "product_price")
    private double price;

    // 수량
    @Column(name = "product_amount")
    private int amount;

    public Product(String name, String description, double price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public void updateInfo(String name, String description, double price, int amount) {
        if (name != null) {
            this.name = name;
        }
        if (description != null) {
            this.description = description;
        }
        if (price != -1) {
            this.price = price;
        }
        if (amount != -1) {
            this.amount = amount;
        }
    }
}
