package com.timlad.springweb.service;

import com.timlad.springweb.data.Customer;
import com.timlad.springweb.data.Order;
import com.timlad.springweb.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CustomerService {
    private CustomerDao customerDao;

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    public List<Order> getOrderByCustomerId (Long customerId) {
        return customerDao.getOrderByCustomerId(customerId);
    }
}
