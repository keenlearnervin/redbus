package com.tech.interview.siply.redbus.service.contract;

import com.tech.interview.siply.redbus.entity.dto.UserDTO;

import java.util.UUID;

public interface UserService {

    UserDTO getById(UUID id);

//    String addNewAcc(UserDTO acc);
}
