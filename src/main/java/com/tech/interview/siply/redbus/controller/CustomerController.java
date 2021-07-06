package com.tech.interview.siply.redbus.controller;

import com.tech.interview.siply.redbus.entity.dto.CustomerDTO;
import com.tech.interview.siply.redbus.service.contract.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public String addNewCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println("In Customer Controller - POST");
        return customerService.addCustomer(customerDTO);
    }
}
