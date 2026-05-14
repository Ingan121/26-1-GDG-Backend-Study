package com.ingan121.shop.order.service;

import java.util.List;

import com.ingan121.shop.order.Order;
import com.ingan121.shop.order.repository.JpaOrderRepository;
import org.springframework.stereotype.Service;

import com.ingan121.shop.order.dto.OrderCreateRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final JpaOrderRepository jpaOrderRepository;

    @Override
    @Transactional
    public Long createOrder(OrderCreateRequest request) {
        Order order = new Order(
                request.getProduct(),
                request.getMember(),
                request.getAddress(),
                request.getOrderDate()
        );

        jpaOrderRepository.save(order);

        return order.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        return jpaOrderRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Order getOrderById(Long id) {
        Order order = jpaOrderRepository.findById(id);

        if (order == null) {
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }

        return order;
    }

    @Override
    @Transactional
    public void deleteOrder(Long id) {
        Order order = jpaOrderRepository.findById(id);

        if (order == null) {
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }

        // Repository를 통해 삭제
        jpaOrderRepository.deleteById(id);
    }


}
