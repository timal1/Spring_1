package com.timlad.springweb.repository;

import com.timlad.springweb.data.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository  {
    private List<Product> products;

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public void setProduct(Product product) {
        products.add(product);
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Пальто", 100.0),
                new Product(2L, "Шляпа", 20.0),
                new Product(3L, "Ботинки", 50.0),
                new Product(4L, "Рубашка", 25.0),
                new Product(5L, "Брюки", 30.0)

        ));
    }

    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId()
                .equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Нет товара с id: " + id));
    }

    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public void changeCoast(Long id, Double delta) {
        Product product = findById(id);
        product.setCoast(product.getCoast() + delta);

    }

    public void addProduct(Product product) {
        Long newId = (products.size() + 1L);
        product.setId(newId);
        setProduct(product);
    }
}
