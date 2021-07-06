package com.tech.interview.siply.redbus.controller;

import com.tech.interview.siply.redbus.entity.dto.CustomerDTO;
import com.tech.interview.siply.redbus.entity.dto.DriverDTO;
import com.tech.interview.siply.redbus.entity.dto.OwnerDTO;
import com.tech.interview.siply.redbus.entity.dto.RegistrationDTO;
import com.tech.interview.siply.redbus.service.contract.CustomerService;
import com.tech.interview.siply.redbus.service.contract.DriverService;
import com.tech.interview.siply.redbus.service.contract.OwnerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/v1//user/registration")
@AllArgsConstructor
public class RegistrationController {

    private final OwnerService ownerService;
    private final CustomerService customerService;
    private final DriverService driverService;

    @PostMapping
    public String registerUser(@RequestBody RegistrationDTO registrationDTO) throws IOException {

        switch (registrationDTO.getUserType()) {
            case USER:
                customerService.addCustomer(new ModelMapper().map(registrationDTO, CustomerDTO.class));
                break;
            case DRIVER:
                driverService.addDriver(new ModelMapper().map(registrationDTO, DriverDTO.class));
                break;
            case OWNER:
                ownerService.addOwner(new ModelMapper().map(registrationDTO, OwnerDTO.class));
                break;
        }

        return "User registered";
    }
}
