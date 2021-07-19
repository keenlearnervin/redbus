package com.tech.interview.siply.redbus.service.contract;

import com.tech.interview.siply.redbus.entity.dto.BusDTO;

import java.util.UUID;

public interface BusService {

    String addNewBus(BusDTO busDTO);

    BusDTO getById(UUID busId);

//    BusDTO getBusesByOwnerId(UUID ownerId);

    void deleteById(UUID busId);
}
