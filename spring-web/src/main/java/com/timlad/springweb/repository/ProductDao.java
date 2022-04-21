package com.timlad.springweb.repository;


import com.timlad.springweb.data.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductDao<T> {

    void create(T obj);

    T findById(int id);

    List<T> getProducts();

    Product saveOrUpdate(T obj);

    void deleteById(int id);

    void changeCoast(int id, int delta);
}
