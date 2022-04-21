package com.timlad.springweb.repository;


import com.timlad.springweb.data.Product;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Primary
@AllArgsConstructor
public class ProductDaoImpl implements ProductDao<Product> {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public void create(Product product) {
        entityManager.persist(product);
    }

    @Override
    @Transactional
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    @Transactional
    public  List<Product> getProducts() {
        List<Product> products = entityManager
                .createQuery("Select p from Product p order by id asc ", Product.class)
                .getResultList();
        return products;
    }

    @Override
    @Transactional
    public Product saveOrUpdate(Product product) {
       return entityManager.merge(product);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);

    }

    @Override
    @Transactional
    public void changeCoast(int id, int delta) {
        Product product = entityManager.find(Product.class, id);
        product.setCoast(product.getCoast() + delta);

    }

}
