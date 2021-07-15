package com.tech.interview.siply.redbus.controller;

import com.tech.interview.siply.redbus.entity.dto.OwnerDTO;
import com.tech.interview.siply.redbus.service.contract.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller layer for OWNER users
 */
@RestController
@RequestMapping("/api/user/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping
    public String addNewOwner(@RequestBody OwnerDTO ownerDTO) {
        System.out.println("In Owner Controller - POST");
        return ownerService.addOwner(ownerDTO);
    }

    @GetMapping
    public String getOwner() {
        return "This is the OWNER";
    }
}
