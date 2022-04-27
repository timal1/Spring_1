package com.timlad.springweb.repository;


import com.timlad.springweb.data.Customer;
import com.timlad.springweb.data.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductDao<T> {

    void create(T obj);

    T findById(Long id);

    List<T> getProducts();

    Product saveOrUpdate(T obj);

    void deleteById(Long id);

    void changeCoast(Long id, double delta);
    List<Customer> getCustomersByProductId(Long idProduct);
}
