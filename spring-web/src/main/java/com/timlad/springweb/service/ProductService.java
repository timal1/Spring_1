package com.timlad.springweb.service;

import com.timlad.springweb.entities.Product;
import com.timlad.springweb.exeptions.ResourceNotFoundException;
import com.timlad.springweb.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllOrderById() {
        return productRepository.findAllOrderById();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void changeCoast(Long productId, double delta) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new ResourceNotFoundException("Unable to change product coast. Product not found, id: " + productId));
        product.setCoast(product.getCoast() + delta);
        productRepository.save(product);
    }

    public List<Product> findAllByCoastBetween(Double minCoast, Double maxCoast) {
        return productRepository.findAllByCoastBetween(minCoast, maxCoast);
    }
}
