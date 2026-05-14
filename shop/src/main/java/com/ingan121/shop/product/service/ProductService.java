package com.ingan121.shop.product.service;

import com.ingan121.shop.product.Product;
import com.ingan121.shop.product.dto.ProductCreateRequest;
import com.ingan121.shop.product.dto.ProductUpdateRequest;

import java.util.List;

public interface ProductService {
    Long createProduct(ProductCreateRequest request);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void updateProduct(Long id, ProductUpdateRequest request);
    void deleteProduct(Long id);
}
