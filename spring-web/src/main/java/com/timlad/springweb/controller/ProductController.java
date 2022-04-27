package com.timlad.springweb.controller;

import com.timlad.springweb.entities.Product;
import com.timlad.springweb.exeptions.ResourceNotFoundException;
import com.timlad.springweb.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.findAllOrderById();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
    }

    @GetMapping("products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/products/change_coast")
    public void changeCoast(@RequestParam Long productId, @RequestParam double delta) {
        productService.changeCoast(productId, delta);
    }

    @PostMapping("/products/save_or_update")
    public void saveOrUpdateProduct(@RequestBody Product product) {
        productService.save(product);
    }

    @GetMapping("/products/coast_between")
    public List<Product> findAllByCoastBetween(@RequestParam Double minCoast, @RequestParam Double maxCoast) {
        return productService.findAllByCoastBetween(minCoast, maxCoast);
    }
}
