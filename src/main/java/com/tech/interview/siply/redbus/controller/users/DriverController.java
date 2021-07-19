package com.tech.interview.siply.redbus.controller.users;

import com.tech.interview.siply.redbus.entity.dto.DriverDTO;
import com.tech.interview.siply.redbus.service.contract.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
        return driverService.addDriver(driverDTO);
    }

    @GetMapping("/all")
    public List<DriverDTO> getAllDrivers() {
        return driverService.getAllDriverUsers();
    }


    @GetMapping("/{driverId}")
    public String getDriver(@PathVariable UUID driverId) {
        return "This is the Driver";
    }
}
