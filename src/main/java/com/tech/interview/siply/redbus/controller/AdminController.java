package com.tech.interview.siply.redbus.controller;

import com.tech.interview.siply.redbus.entity.dto.AdminDTO;
import com.tech.interview.siply.redbus.service.contract.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller layer for ADMIN users
 */
@RestController
@RequestMapping("/api/user/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping
    public String addNewAdmin(@RequestBody AdminDTO adminDTO) {
        System.out.println("In Admin Controller - POST");
        return adminService.addAdmin(adminDTO);
    }


    @GetMapping
    public String getAdmin() {
        return "This is the ADMIN";
    }
}
