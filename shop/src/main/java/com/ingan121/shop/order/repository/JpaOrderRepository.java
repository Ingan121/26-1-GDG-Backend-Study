package com.ingan121.shop.order.repository;

import com.ingan121.shop.order.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class JpaOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Order findById(Long id) {
        // em에서 ID로 조회
        return em.find(Order.class, id);
    }

    @Override
    public List<Order> findAll() {
        return em.createQuery("SELECT m FROM Order m", Order.class)
                .getResultList();
    }

    @Override
    public void save(Order order) {
        em.persist(order);
    }

    @Override
    public void deleteById(Long id) {
        Order order = em.find(Order.class, id);
        em.remove(order);
    }
}

