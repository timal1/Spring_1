package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // получение товара по id
        OrderService orderService = context.getBean(OrderService.class);
        orderService.createOrderFromProduct(1L);
        System.out.println();

        // получение списка товаров
        ProductService productService = context.getBean(ProductService.class);
        productService.getListProduct();
        System.out.println();

        // консольное приложение для работы с корзиной
        Cart cart = context.getBean(Cart.class);

        System.out.println("Чтобы добавить товар, введите добавить, нажмите Enter и номер товара, нажмите Enter \n" +
                "чтобы удалить товар, введите удалить, нажмите Enter и номер товара, нажмите Enter \n" +
                "чтобы выйти из приложения, введите выйти и нажмите Enter");

        Scanner scanner = new Scanner(System.in);

        while (true) {

            String command = scanner.nextLine();

            if (command.equals("добавить")) {
                Long id = scanner.nextLong();
                cart.addProductInCart(id);
                cart.getCart();
                System.out.println();
                continue;
            } else if (command.equals("удалить")) {
                Long id = scanner.nextLong();
                cart.removeProductOfCart(id);
                cart.getCart();
                System.out.println();
                continue;
            } else if (command.equals("выйти")) {
                context.close();
                break;
            }
        }
    }
}
