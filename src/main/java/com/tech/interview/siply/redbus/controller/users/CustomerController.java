package com.tech.interview.siply.redbus.controller.users;

import com.tech.interview.siply.redbus.entity.dto.CustomerDTO;
import com.tech.interview.siply.redbus.service.contract.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controller layer for CUSTOMER users
 */
@RestController
@RequestMapping("/api/user/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public String addNewCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.addCustomer(customerDTO);
    }

    @GetMapping("/all")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomersUsers();
    }


    @GetMapping("/{custId}")
    public String getCustomer(@PathVariable UUID custId) {
        return "This is the CUSTOMER";
    }
}
