package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
    private Logger logger = LoggerFactory.getLogger(ProductService.class);

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String getTitleById(Long id) {
        return productRepository.findById(id).getTitle();
    }


    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }



    public void getListProduct() {
        logger.info("Get all products");
        System.out.println("Список товаров: ");

        for (Product pr: productRepository.getProducts()) {
            System.out.println(pr.toString());
        }
    }
}
