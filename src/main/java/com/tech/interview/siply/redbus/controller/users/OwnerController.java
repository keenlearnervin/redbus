package com.tech.interview.siply.redbus.controller.users;

import com.tech.interview.siply.redbus.entity.dto.OwnerDTO;
import com.tech.interview.siply.redbus.service.contract.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
        return ownerService.addOwner(ownerDTO);
    }

    @GetMapping("/all")
    public List<OwnerDTO> getAllOwners() {
        return ownerService.getAllOwnerUsers();
    }

    @GetMapping("/{ownerId}")
    public String getOwner(@PathVariable UUID ownerId) {
        return "This is the OWNER";
    }
}
