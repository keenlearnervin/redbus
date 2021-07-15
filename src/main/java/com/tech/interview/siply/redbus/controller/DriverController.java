package com.tech.interview.siply.redbus.controller;

import com.tech.interview.siply.redbus.entity.dto.DriverDTO;
import com.tech.interview.siply.redbus.service.contract.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller layer for DRIVER users
 */
@RestController
@RequestMapping("/api/user/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping
    public String addNewDriver(@RequestBody DriverDTO driverDTO) {
        System.out.println("In Driver Controller - POST");
        return driverService.addDriver(driverDTO);
    }


    @GetMapping
    public String getDriver() {
        return "This is the Driver";
    }
}
