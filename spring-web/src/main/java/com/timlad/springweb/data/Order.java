package com.timlad.springweb.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_amount")
    private double orderAmount;

    @Column(name = "order_date")
    private Date orderDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public String toString(){

        return "Номер заказ: " + id + " имя покупателя: " + customer.getName() + " наименование товара: "
                + product.getTitle() + " сумма заказ: " + orderAmount + " дата заказа: " + orderDate;
    }
}
