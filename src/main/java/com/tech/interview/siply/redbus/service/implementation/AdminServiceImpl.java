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

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService, UserDetailsService {
    final ModelMapper modelMapper = new ModelMapper();

    AdminRepository adminRepository;

    @Override
    public String addAdmin(AdminDTO adminDTO) {
        UserDTO userDTO = modelMapper.map(adminDTO, UserDTO.class);
        Admin admin = new Admin(userDTO, adminDTO);
        adminRepository.save(admin);
        return "Saved Admin";
    }

    @Override
    public void deleteAdminUser(UUID id) {
        adminRepository.deleteById(id);
    }

    @Override
    public AdminDTO getAdminById(UUID id) {
        Admin admin = adminRepository.findById(id).get();
        AdminDTO adminDTO = modelMapper.map(adminRepository.findById(id).get(), AdminDTO.class);

        return adminDTO;
    }

    @Override
    public List<AdminDTO> getAllAdminUsers() {
        return adminRepository.findAll().stream().map(admin ->
                modelMapper.map(admin, AdminDTO.class)
        ).collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Admin> adminUser = adminRepository.findByUserName(userName);
        return new RedbusUserDetails(adminUser.orElseThrow(() -> new UsernameNotFoundException("Admin User Not found.")));
    }
}
