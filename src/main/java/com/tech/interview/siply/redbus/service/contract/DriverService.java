package com.tech.interview.siply.redbus.service.contract;

import com.tech.interview.siply.redbus.entity.dto.DriverDTO;

import java.util.List;
import java.util.UUID;

public interface DriverService {
    String addDriver(DriverDTO driverDTO);

    void deleteDriverUser(UUID id);

    DriverDTO getDriverById(UUID id);

    List<DriverDTO> getAllDriverUsers();
}
