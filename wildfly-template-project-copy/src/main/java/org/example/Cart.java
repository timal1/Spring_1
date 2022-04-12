package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private Logger logger = LoggerFactory.getLogger(Cart.class);

    private ProductService productService;
    private List<Product> cart;


    public Cart(ProductService productService) {
        this.productService = productService;
        this.cart = new ArrayList<>();
    }

    public void addProductInCart(Long id) {
        logger.info("Add product to cart");
        Product product = productService.getProductById(id);
        cart.add(product);
        System.out.println("Вы добавили в корзину " + product.toString());
    }

    public void removeProductOfCart(Long id) {
        logger.info("Remove product to cart");
        Product product = productService.getProductById(id);
        cart.remove(product);
        System.out.println("Вы удалили из корзины " + product.toString());
    }

    public void getCart() {
        logger.info("List product in cart");
        if (!cart.isEmpty()) {
            System.out.println("Товары в вашей корзине: ");
            for (Product pr: cart) {
                System.out.println(pr.toString());
            }

            return;
        }
        System.out.println("Ваша корзина пуста");
    }

}
