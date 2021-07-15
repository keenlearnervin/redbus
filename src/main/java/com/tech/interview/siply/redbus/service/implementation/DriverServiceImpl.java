package com.tech.interview.siply.redbus.service.implementation;

import com.tech.interview.siply.redbus.configuration.RedbusUserDetails;
import com.tech.interview.siply.redbus.entity.dao.users.Driver;
import com.tech.interview.siply.redbus.entity.dto.DriverDTO;
import com.tech.interview.siply.redbus.entity.dto.UserDTO;
import com.tech.interview.siply.redbus.repository.contract.users.DriverRepository;
import com.tech.interview.siply.redbus.service.contract.DriverService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService, UserDetailsService {
     ModelMapper modelMapper = new ModelMapper();

    @Autowired
    DriverRepository driverRepository;

    @Override
    public String addDriver(DriverDTO driverDTO) {
        UserDTO userDTO = modelMapper.map(driverDTO, UserDTO.class);
        Driver driver = new Driver(userDTO, driverDTO);
        driverRepository.save(driver);
        return "Saved Driver";
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Driver> driverUser = driverRepository.findByUserName(userName);
        return new RedbusUserDetails(driverUser.orElseThrow(() -> new UsernameNotFoundException("Driver Not Found")));
    }
}
