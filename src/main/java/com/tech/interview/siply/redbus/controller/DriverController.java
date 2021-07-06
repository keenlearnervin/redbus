package com.tech.interview.siply.redbus.controller;

import com.tech.interview.siply.redbus.entity.dto.DriverDTO;
import com.tech.interview.siply.redbus.service.contract.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping
    public String addNewDriver(@RequestBody DriverDTO driverDTO) {
        System.out.println("In Driver Controller - POST");
        return driverService.addDriver(driverDTO);
    }
}
