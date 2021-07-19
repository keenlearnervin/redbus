package com.tech.interview.siply.redbus.service.contract;

import com.tech.interview.siply.redbus.entity.dto.OwnerDTO;

import java.util.List;
import java.util.UUID;

public interface OwnerService {
    String addOwner(OwnerDTO acc);

    List<OwnerDTO> getAllOwnerUsers();

    void deleteOwnerUser(UUID id);

    OwnerDTO getOwnerById(UUID id);
}
