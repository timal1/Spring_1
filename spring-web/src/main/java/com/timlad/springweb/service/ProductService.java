package com.timlad.springweb.service;

import com.timlad.springweb.data.Product;
import com.timlad.springweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(@Qualifier("productRepository") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String getTitleById(Long id) {
        return productRepository.findById(id).getTitle();
    }


    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }


    public List<Product> getListProduct() {
        return productRepository.getProducts();
    }

    public void save(Product product) {
        productRepository.setProduct(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteProduct(id);
    }

    public void changeCoast(Long id, Double delta) {
        productRepository.changeCoast(id, delta);
    }

    public void addProduct(Product product) {

        productRepository.addProduct(product);
    }
}
