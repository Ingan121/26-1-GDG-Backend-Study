package com.ingan121.shop.order.service;

import com.ingan121.shop.order.Order;
import com.ingan121.shop.order.dto.OrderCreateRequest;

import java.util.List;

public interface OrderService {
    Long createOrder(OrderCreateRequest request);
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    void deleteOrder(Long id);
}
