package com.tech.interview.siply.redbus.service.implementation;

import com.tech.interview.siply.redbus.configuration.RedbusUserDetails;
import com.tech.interview.siply.redbus.entity.dao.users.Customer;
import com.tech.interview.siply.redbus.entity.dto.CustomerDTO;
import com.tech.interview.siply.redbus.entity.dto.UserDTO;
import com.tech.interview.siply.redbus.repository.contract.users.CustomerRepository;
import com.tech.interview.siply.redbus.service.contract.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService, UserDetailsService {
    final ModelMapper modelMapper = new ModelMapper();
    CustomerRepository customerRepository;

    @Override
    public String addCustomer(CustomerDTO customerDTO) {

        UserDTO userDTO = modelMapper.map(customerDTO, UserDTO.class);
        Customer customer = new Customer(userDTO, customerDTO);
        customerRepository.save(customer);
        return "Saved Customer";
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Customer> customerUser = customerRepository.findByUserName(userName);
        return new RedbusUserDetails(customerUser.orElseThrow(() -> new UsernameNotFoundException("Customer not found")));
    }
}
