package com.timlad.springweb.repository;

import com.timlad.springweb.data.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Component
@AllArgsConstructor
public class CustomerDao {

    private final EntityManager entityManager;

    @Transactional
    public List<Order> getOrderByCustomerId (Long customerId) {
        return entityManager.createQuery("select o from Order o where o.customer.id = :customerId", Order.class)
                .setParameter("customerId", customerId).getResultList();

    }
}
