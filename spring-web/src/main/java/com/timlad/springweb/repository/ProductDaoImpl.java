package com.timlad.springweb.repository;


import com.timlad.springweb.data.Customer;
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
    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    @Transactional
    public  List<Product> getProducts() {
        List<Product> products = entityManager
                .createQuery("Select p from Product p order by p.id asc ", Product.class)
                .getResultList();
     //   System.out.println(products.toString());
        return products;
    }

    @Override
    @Transactional
    public Product saveOrUpdate(Product product) {
       return entityManager.merge(product);

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);

    }

    @Override
    @Transactional
    public void changeCoast(Long id, double delta) {
        Product product = entityManager.find(Product.class, id);
        product.setCoast(product.getCoast() + delta);
    }

    @Override
    @Transactional
    public List<Customer> getCustomersByProductId(Long idProduct) {
        return entityManager.createQuery("select o.customer.name from Order o where o.product.id = :id_product")
                .setParameter("id_product", idProduct).getResultList();

//        if (customers.size() == 0) {
//
//            System.out.println("Товар с id = " + idProduct + " никто не покупал");
//            return;
//        }
//        for (Customer c: customers) {
//            System.out.println(c.getName());
//        }
    }
}
