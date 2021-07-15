package com.tech.interview.siply.redbus.service.implementation;

import com.tech.interview.siply.redbus.configuration.RedbusUserDetails;
import com.tech.interview.siply.redbus.entity.dao.users.Admin;
import com.tech.interview.siply.redbus.entity.dto.AdminDTO;
import com.tech.interview.siply.redbus.entity.dto.UserDTO;
import com.tech.interview.siply.redbus.repository.contract.users.AdminRepository;
import com.tech.interview.siply.redbus.service.contract.AdminService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService, UserDetailsService {
    final ModelMapper modelMapper = new ModelMapper();

    AdminRepository adminRepository;

    @Override
    public String addAdmin(AdminDTO adminDTO) {
        UserDTO userDTO = modelMapper.map(adminDTO, UserDTO.class);
        Admin admin = new Admin(userDTO, adminDTO);
        System.out.println();
        adminRepository.save(admin);
        return "Saved Admin";
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Admin> adminUser = adminRepository.findByUserName(userName);
        return new RedbusUserDetails(adminUser.orElseThrow(() -> new UsernameNotFoundException("Admin User Not found.")));
    }
}
