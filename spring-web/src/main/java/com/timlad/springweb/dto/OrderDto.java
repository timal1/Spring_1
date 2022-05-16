package com.timlad.springweb.dto;

import com.timlad.springweb.entities.Order;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private double orderAmount;
    private Date orderDate;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.orderAmount = order.getOrderAmount();
        this.orderDate = order.getOrderDate();
    }
}
