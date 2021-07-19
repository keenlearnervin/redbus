package com.tech.interview.siply.redbus.service.implementation;

import com.tech.interview.siply.redbus.configuration.RedbusUserDetails;
import com.tech.interview.siply.redbus.entity.dao.users.Owner;
import com.tech.interview.siply.redbus.entity.dto.OwnerDTO;
import com.tech.interview.siply.redbus.entity.dto.UserDTO;
import com.tech.interview.siply.redbus.repository.contract.users.OwnerRepository;
import com.tech.interview.siply.redbus.service.contract.OwnerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class OwnerServiceImpl implements OwnerService, UserDetailsService {
    final ModelMapper modelMapper = new ModelMapper();

    OwnerRepository ownerRepository;

    @Override
    public String addOwner(OwnerDTO ownerDTO) {
        UserDTO userDTO = modelMapper.map(ownerDTO, UserDTO.class);
        Owner owner = new Owner(userDTO, ownerDTO);
        ownerRepository.save(owner);
        return "Saved Owner";
    }

    @Override
    public List<OwnerDTO> getAllOwnerUsers() {
        Pageable pageable = PageRequest.of(0,10);
        return ownerRepository.findAll(pageable).stream().map(owner ->
                modelMapper.map(owner, OwnerDTO.class)
        ).collect(Collectors.toList());
    }

    @Override
    public void deleteOwnerUser(UUID id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public OwnerDTO getOwnerById(UUID id) {
        return modelMapper.map(ownerRepository.findById(id).get(), OwnerDTO.class);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Owner> ownerUser = ownerRepository.findByUserName(userName);
        return new RedbusUserDetails(ownerUser.orElseThrow(() -> new UsernameNotFoundException("Owner not found")));
    }
}
