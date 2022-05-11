package com.timlad.springweb.controller;

import com.timlad.springweb.entities.Product;
import com.timlad.springweb.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("/products")
//    public List<Product> getProductsFirstPage() {
//        List<Product> productList = new ArrayList<>();
//        List<Product> products = productService.findAllOrderById();
//        for (int i = 0; i < 10; i++ ) {
//            productList.add(products.get(i));
//        }
//        return productList;
//    }

    @GetMapping("/products")
    public List<Product> getProductsByNumberPage(@RequestParam int numberPage) {
        List<Product> productList = new ArrayList<>();
        List<Product> products = productService.findAllOrderById();
        if(numberPage * 10 > products.size()) {
            for (int i = numberPage * 10 - 10; i < products.size(); i++ ) {
                productList.add(products.get(i));
            }
            return productList;
        }
        if(numberPage * 10 - 10 > products.size()) {
            return null;
        }
        for (int i = numberPage * 10 - 10; i < numberPage * 10; i++ ) {
            productList.add(products.get(i));
        }
        return productList;
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
    public List<Product> findAllByCoastBetween(@RequestParam Double minCoast,
                                               @RequestParam Double maxCoast) {

        return productService.findAllByCoastBetween(minCoast, maxCoast);

    }
}
