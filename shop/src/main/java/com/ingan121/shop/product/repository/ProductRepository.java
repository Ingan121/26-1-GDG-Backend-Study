package com.ingan121.shop.product.repository;

import com.ingan121.shop.product.Product;

import java.util.List;

public interface ProductRepository {
    Product findById(Long id);
    List<Product> findAll();
    void save(Product product);
    void deleteById(Long id);
}
