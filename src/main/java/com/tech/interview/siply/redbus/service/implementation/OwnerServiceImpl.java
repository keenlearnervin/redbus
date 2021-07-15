package com.tech.interview.siply.redbus.service.implementation;

import com.tech.interview.siply.redbus.configuration.RedbusUserDetails;
import com.tech.interview.siply.redbus.entity.dao.users.Owner;
import com.tech.interview.siply.redbus.entity.dto.OwnerDTO;
import com.tech.interview.siply.redbus.entity.dto.UserDTO;
import com.tech.interview.siply.redbus.repository.contract.users.OwnerRepository;
import com.tech.interview.siply.redbus.service.contract.OwnerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OwnerServiceImpl implements OwnerService, UserDetailsService {
    final ModelMapper modelMapper = new ModelMapper();

    OwnerRepository ownerRepository;

    @Override
    public String addOwner(OwnerDTO ownerDTO) {
        UserDTO userDTO = modelMapper.map(ownerDTO, UserDTO.class);
        Owner owner = new Owner(userDTO, ownerDTO);
        System.out.println();
        ownerRepository.save(owner);
        return "Saved Owner";
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Owner> ownerUser = ownerRepository.findByUserName(userName);
        return new RedbusUserDetails(ownerUser.orElseThrow(() -> new UsernameNotFoundException("Owner not found")));
    }
}
