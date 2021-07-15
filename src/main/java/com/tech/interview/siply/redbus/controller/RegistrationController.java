package com.tech.interview.siply.redbus.controller;

import com.tech.interview.siply.redbus.entity.dto.*;
import com.tech.interview.siply.redbus.service.contract.AdminService;
import com.tech.interview.siply.redbus.service.contract.CustomerService;
import com.tech.interview.siply.redbus.service.contract.DriverService;
import com.tech.interview.siply.redbus.service.contract.OwnerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Controller layer for registering new users
 */
@RestController
@RequestMapping("api/newuser/registration")
@AllArgsConstructor
public class RegistrationController {

    private final OwnerService ownerService;
    private final CustomerService customerService;
    private final DriverService driverService;
    private final AdminService adminService;
    private final PasswordEncoder encoder;

    @PostMapping
    public String registerUser(@RequestBody RegistrationDTO registrationDTO) throws IOException {
//        String encodedPassword = encoder.encode(registrationDTO.getPassword());
//        String encodedAnswer = encoder.encode(registrationDTO.getVerifyAnswer());
//        registrationDTO.setPassword(encodedPassword);
//        registrationDTO.setVerifyAnswer(encodedAnswer);
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
            case ADMIN:
                adminService.addAdmin(new ModelMapper().map(registrationDTO, AdminDTO.class));
        }

        return "User registered";
    }
}
