package com.tech.interview.siply.redbus.service.implementation;

import com.tech.interview.siply.redbus.entity.dao.users.Owner;
import com.tech.interview.siply.redbus.entity.dto.OwnerDTO;
import com.tech.interview.siply.redbus.entity.dto.UserDTO;
import com.tech.interview.siply.redbus.repository.contract.users.OwnerRepository;
import com.tech.interview.siply.redbus.service.contract.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {
    final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public String addOwner(OwnerDTO ownerDTO) {
        UserDTO userDTO = modelMapper.map(ownerDTO, UserDTO.class);
        Owner owner = new Owner(userDTO, ownerDTO);
        System.out.println();
        ownerRepository.save(owner);
        return "Saved Owner";
    }
}
