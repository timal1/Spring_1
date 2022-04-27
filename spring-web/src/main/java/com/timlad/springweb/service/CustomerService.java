package com.timlad.springweb.service;

import com.timlad.springweb.repository.CustomerRepository;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
