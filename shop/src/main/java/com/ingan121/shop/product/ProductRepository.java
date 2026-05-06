package com.ingan121.shop.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;

    public Product findById(Long id) {
        // em에서 ID로 조회
        return em.find(Product.class, id);
    }

    public List<Product> findAll() {
        return em.createQuery("SELECT m FROM Product m", Product.class)
                .getResultList();
    }

    public void save(Product product) {
        em.persist(product);
    }

    public void deleteById(Long id) {
        Product product = em.find(Product.class, id);
        em.remove(product);
    }
}

