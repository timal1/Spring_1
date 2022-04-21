package com.timlad.springweb.controller;

import com.timlad.springweb.data.Product;
import com.timlad.springweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> showAllProducts() {
        return productService.getListProduct();

    }

    @GetMapping("products/delete/{id}")
    public void deleteById(@PathVariable int id) {
       productService.deleteById(id);
    }

    @GetMapping("/products/change_coast")
    public void changeCoast(@RequestParam int productId, @RequestParam int delta) {
        productService.changeCoast(productId, delta);
    }

    @PostMapping("/products/add_product")
    public void addProduct(@RequestBody Product product) {
        productService.create(product);
    }
}
