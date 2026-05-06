package com.ingan121.shop.order.dto;

// productId, memberId, address, orderDate

import com.ingan121.shop.member.Member;
import com.ingan121.shop.member.MemberRepository;
import com.ingan121.shop.product.Product;
import com.ingan121.shop.product.ProductRepository;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderCreateRequest {

    private Product product;
    private Member member;
    private String address;
    private LocalDateTime orderDate;

    public OrderCreateRequest(Long productId, Long memberId, String address, LocalDateTime orderDate) {
        // 몰루겠다
//        ProductRepository productRepository = new ProductRepository();
//        MemberRepository memberRepository = new MemberRepository();
//
//        this.product = productRepository.findById(productId);
//        this.member = memberRepository.findById(memberId);
        this.address = address;
        this.orderDate = orderDate;
    }
}
