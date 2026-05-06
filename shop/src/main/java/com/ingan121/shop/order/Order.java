package com.ingan121.shop.order;

import com.ingan121.shop.member.Member;
import com.ingan121.shop.product.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    // 주문 고유 식별자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    // 상품 아이디
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    // 주문자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // 주소
    @Column(name = "order_address", length = 255)
    private String address;

    // 주문 일시
    @Column(name = "order_date")
    private LocalDateTime orderDate;

    public Order(Product product, Member member, String address, LocalDateTime orderDate) {
        this.product = product;
        this.member = member;
        this.address = address;
        this.orderDate = orderDate;
    }
}
