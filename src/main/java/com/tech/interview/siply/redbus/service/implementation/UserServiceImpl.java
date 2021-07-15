package com.tech.interview.siply.redbus.service.implementation;

import com.tech.interview.siply.redbus.configuration.RedbusUserDetails;
import com.tech.interview.siply.redbus.entity.dao.users.Owner;
import com.tech.interview.siply.redbus.entity.dao.users.User;
import com.tech.interview.siply.redbus.entity.dto.UserDTO;
import com.tech.interview.siply.redbus.repository.contract.users.UserRepository;
import com.tech.interview.siply.redbus.service.contract.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Primary
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDTO getById(UUID id) {
        return null;
    }

    public UserDTO getByEmail(String emailAddress) {
        UserDTO userDTO = new UserDTO();
        Optional<User> user = userRepository.findByEmailAddress(emailAddress);
        if (user.isPresent()) {
            userDTO = new ModelMapper().map(user.get(), UserDTO.class);
        } else
            throw new UsernameNotFoundException("User with email id '" + emailAddress + "' not found.");

        return userDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
        return new RedbusUserDetails(user.orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }
}
