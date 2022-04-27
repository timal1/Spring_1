package com.timlad.springweb.controller;

import com.timlad.springweb.data.Customer;
import com.timlad.springweb.data.Order;
import com.timlad.springweb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/customer_orders/{id}")
    public void getOrdersByIdCustomer(@PathVariable Long id) {
              System.out.println(customerService.getOrderByCustomerId(id));
   //     return customerService.getOrderByCustomerId(id);
    }

}
