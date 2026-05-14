package com.ingan121.shop.order.repository;

import com.ingan121.shop.order.Order;

import java.util.List;

public interface OrderRepository {
    Order findById(Long id);
    List<Order> findAll();
    void save(Order order);
    void deleteById(Long id);
}
