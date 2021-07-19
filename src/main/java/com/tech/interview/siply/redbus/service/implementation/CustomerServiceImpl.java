package com.tech.interview.siply.redbus.service.implementation;

import com.tech.interview.siply.redbus.configuration.RedbusUserDetails;
import com.tech.interview.siply.redbus.entity.dao.users.Customer;
import com.tech.interview.siply.redbus.entity.dto.CustomerDTO;
import com.tech.interview.siply.redbus.entity.dto.UserDTO;
import com.tech.interview.siply.redbus.repository.contract.users.CustomerRepository;
import com.tech.interview.siply.redbus.service.contract.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public void deleteCustomerUser(UUID id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDTO getCustomerById(UUID id) {
        return modelMapper.map(customerRepository.findById(id).get(), CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> getAllCustomersUsers() {
        Pageable pageable = PageRequest.of(0,10);
        return customerRepository.findAll(pageable).stream().map(customer ->
                modelMapper.map(customer, CustomerDTO.class)
        ).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Customer> customerUser = customerRepository.findByUserName(userName);
        return new RedbusUserDetails(customerUser.orElseThrow(() -> new UsernameNotFoundException("Customer not found")));
    }
}
