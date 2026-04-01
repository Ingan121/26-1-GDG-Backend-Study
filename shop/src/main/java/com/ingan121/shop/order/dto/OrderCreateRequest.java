package com.ingan121.shop.order.dto;

// orderId, productId, memberId, address

import lombok.Getter;

@Getter
public class OrderCreateRequest {

    private String orderId;
    private String productId;
    private String memberId;
    private String address;

    public OrderCreateRequest(String orderId, String productId, String memberId, String address) {
        this.orderId = orderId;
        this.productId = productId;
        this.memberId = memberId;
        this.address = address;
    }
}
