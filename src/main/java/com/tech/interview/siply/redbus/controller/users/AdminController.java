package com.tech.interview.siply.redbus.controller.users;

import com.tech.interview.siply.redbus.entity.dto.AdminDTO;
import com.tech.interview.siply.redbus.service.contract.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
        return adminService.addAdmin(adminDTO);
    }


    @GetMapping("/{id}")
    public AdminDTO getAdmin(@PathVariable UUID id) {
        return adminService.getAdminById(id);
    }

    @GetMapping("/all")
    public List<AdminDTO> getAllAdmins() {
        return adminService.getAllAdminUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable UUID id) {
        adminService.deleteAdminUser(id);
    }
}
