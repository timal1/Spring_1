package org.example;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InMemProductRepository implements ProductRepository {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Пальто", 100L),
                new Product(2L, "Шляпа", 20L),
                new Product(3L, "Ботинки", 50L),
                new Product(4L, "Рубашка", 25L),
                new Product(5L, "Брюки", 30L)

        ));
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId()
                .equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException());
    }
}
