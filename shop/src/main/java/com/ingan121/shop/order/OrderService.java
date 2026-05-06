package com.ingan121.shop.order;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ingan121.shop.order.dto.OrderCreateRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public long createOrder(OrderCreateRequest request) {
        Order order = new Order(
                request.getProduct(),
                request.getMember(),
                request.getAddress(),
                request.getOrderDate()
        );

        orderRepository.save(order);

        return order.getId();
    }

    @Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id);

        if (order == null) {
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }

        return order;
    }

    @Transactional
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id);

        if (order == null) {
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }

        // Repository를 통해 삭제
        orderRepository.deleteById(id);
    }


}
