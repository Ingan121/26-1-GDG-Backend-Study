package com.ingan121.shop.order;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ingan121.shop.order.dto.OrderCreateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    //@Transactional
    public long createOrder(OrderCreateRequest request) {
        Order existingOrder = orderRepository.findByOrderId(request.getOrderId());
        if (existingOrder != null) {
            throw new RuntimeException("이미 존재하는 주문 아이디입니다: " + request.getOrderId());
        }

        Order order = new Order(
                request.getOrderId(),
                request.getProductId(),
                request.getMemberId(),
                request.getAddress()
        );

        orderRepository.save(order);

        return order.getId();
    }

    //@Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    //@Transactional(readOnly = true)
    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id);

        if (order == null) {
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }

        return order;
    }

    //@Transactional
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id);

        if (order == null) {
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }

        // Repository를 통해 삭제
        orderRepository.deleteById(id);
    }


}
