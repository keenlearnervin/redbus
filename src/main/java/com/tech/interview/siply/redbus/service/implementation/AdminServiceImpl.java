package com.tech.interview.siply.redbus.service.implementation;

import com.tech.interview.siply.redbus.entity.dao.users.Admin;
import com.tech.interview.siply.redbus.entity.dao.users.Owner;
import com.tech.interview.siply.redbus.entity.dto.AdminDTO;
import com.tech.interview.siply.redbus.entity.dto.UserDTO;
import com.tech.interview.siply.redbus.repository.contract.users.AdminRepository;
import com.tech.interview.siply.redbus.service.contract.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    AdminRepository adminRepository;

    @Override
    public String addAdmin(AdminDTO adminDTO) {
        UserDTO userDTO = modelMapper.map(adminDTO, UserDTO.class);
        Admin admin = new Admin(userDTO, adminDTO);
        System.out.println();
        adminRepository.save(admin);
        return "Saved Admin";
    }
}
