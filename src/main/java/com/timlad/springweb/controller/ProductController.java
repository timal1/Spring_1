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
    public void deleteById(@PathVariable Long id) {
       productService.deleteById(id);
    }

    @GetMapping("/products/change_coast")
    public void changeCoast(@RequestParam Long productId, @RequestParam double delta) {
        productService.changeCoast(productId, delta);
    }


    @PostMapping("/products/update_product")
    public void update(@RequestBody Product product) {
        System.out.println(product.toString());
        System.out.println(product.getId());
        productService.saveOrUpdate(product);
    }

    @GetMapping("/products/product_customers/{id}")
    public void getCustomersByProductId(@PathVariable Long id) {
        System.out.println(productService.getCustomersByProductId(id));
 //      return productService.getCustomersByProductId(id);
    }
}
