package com.timlad.springweb.dto;

import com.timlad.springweb.entities.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDto {

    private Long id;
    private String name;

    public CustomerDto(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
    }
}
