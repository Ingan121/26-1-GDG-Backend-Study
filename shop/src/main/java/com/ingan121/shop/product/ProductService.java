package com.ingan121.shop.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ingan121.shop.product.dto.ProductUpdateRequest;
import com.ingan121.shop.product.dto.ProductCreateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    //@Transactional
    public long createProduct(ProductCreateRequest request) {
        Product existingProduct = productRepository.findByProductId(request.getProductId());
        if (existingProduct != null) {
            throw new RuntimeException("이미 존재하는 상품 아이디입니다: " + request.getProductId());
        }

        Product product = new Product(
                request.getProductId(),
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                request.getAmount()
        );

        productRepository.save(product);

        return product.getId();
    }

    //@Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //@Transactional(readOnly = true)
    public Product getProductById(Long id) {
        Product product = productRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        return product;
    }

    //@Transactional
    public void updateProduct(Long id, ProductUpdateRequest request) {
        Product product = productRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        // 상품 정보 수정 (도메인 객체의 메서드 사용)
        product.updateInfo(request.getName(), request.getDescription(), request.getPrice(), request.getAmount());
    }

    //@Transactional
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id);

        if (product == null) {
            throw new RuntimeException("상품을 찾을 수 없습니다.");
        }

        // Repository를 통해 삭제
        productRepository.deleteById(id);
    }


}
