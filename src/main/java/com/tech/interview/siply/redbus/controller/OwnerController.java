package com.tech.interview.siply.redbus.controller;

import com.tech.interview.siply.redbus.entity.dto.OwnerDTO;
import com.tech.interview.siply.redbus.service.contract.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping
    public String addNewOwner(@RequestBody OwnerDTO ownerDTO) {
        System.out.println("In Owner Controller - POST");
        return ownerService.addOwner(ownerDTO);
    }
}
