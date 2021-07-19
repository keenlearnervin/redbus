package com.tech.interview.siply.redbus.service.contract;

import com.tech.interview.siply.redbus.entity.dto.AdminDTO;

import java.util.List;
import java.util.UUID;

public interface AdminService {
    String addAdmin(AdminDTO adminDTO);

    void deleteAdminUser(UUID id);

    AdminDTO getAdminById(UUID fromString);

    List<AdminDTO> getAllAdminUsers();
}
