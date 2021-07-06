package com.tech.interview.siply.redbus.service.implementation;

import com.tech.interview.siply.redbus.entity.dao.users.Driver;
import com.tech.interview.siply.redbus.entity.dto.DriverDTO;
import com.tech.interview.siply.redbus.entity.dto.UserDTO;
import com.tech.interview.siply.redbus.repository.contract.users.DriverRepository;
import com.tech.interview.siply.redbus.service.contract.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {
    final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    DriverRepository driverRepository;

    @Override
    public String addDriver(DriverDTO driverDTO) {
        UserDTO userDTO = modelMapper.map(driverDTO, UserDTO.class);
        Driver driver = new Driver(userDTO, driverDTO);
        driverRepository.save(driver);
        return "Saved Driver";
    }
}
