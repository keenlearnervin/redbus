package com.tech.interview.siply.redbus.service.contract;

import com.tech.interview.siply.redbus.entity.dto.CustomerDTO;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    String addCustomer(CustomerDTO customerDTO);

    void deleteCustomerUser(UUID id);

    CustomerDTO getCustomerById(UUID id);

    List<CustomerDTO> getAllCustomersUsers();
}
