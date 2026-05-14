package com.ingan121.shop.product.service;

import java.util.List;

import com.ingan121.shop.product.Product;
import com.ingan121.shop.product.repository.JpaProductRepository;
import com.ingan121.shop.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import com.ingan121.shop.product.dto.ProductUpdateRequest;
import com.ingan121.shop.product.dto.ProductCreateRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final JpaProductRepository jpaProductRepository;

    @Override
    @Transactional
    public Long createProduct(ProductCreateRequest request) {
        Product product = new Product(
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                request.getAmount()
        );

        jpaProductRepository.save(product);

        return product.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return jpaProductRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProductById(Long id) {
        Product product = jpaProductRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        return product;
    }

    @Override
    @Transactional
    public void updateProduct(Long id, ProductUpdateRequest request) {
        Product product = jpaProductRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        // 상품 정보 수정 (도메인 객체의 메서드 사용)
        product.updateInfo(request.getName(), request.getDescription(), request.getPrice(), request.getAmount());
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        Product product = jpaProductRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        // Repository를 통해 삭제
        jpaProductRepository.deleteById(id);
    }


}
