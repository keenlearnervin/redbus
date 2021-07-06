package com.tech.interview.siply.redbus.service.implementation;

import com.tech.interview.siply.redbus.entity.dao.users.Customer;
import com.tech.interview.siply.redbus.entity.dto.CustomerDTO;
import com.tech.interview.siply.redbus.entity.dto.UserDTO;
import com.tech.interview.siply.redbus.repository.contract.users.CustomerRepository;
import com.tech.interview.siply.redbus.service.contract.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public String addCustomer(CustomerDTO customerDTO) {

        UserDTO userDTO = modelMapper.map(customerDTO, UserDTO.class);
        Customer customer = new Customer(userDTO, customerDTO);
        customerRepository.save(customer);
        return "Saved Customer";
    }
}
