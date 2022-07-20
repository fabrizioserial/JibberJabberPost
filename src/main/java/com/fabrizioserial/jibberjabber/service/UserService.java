package com.fabrizioserial.jibberjabber.service;

import com.fabrizioserial.jibberjabber.DTO.UserDto;
import com.fabrizioserial.jibberjabber.model.User;

import java.util.UUID;

public interface UserService {
    UserDto getLoggedUser();

    UserDto getUser(UUID userId);

    UserDto searchUser(String searchUser);

    User getCurrentUser();

    User getUserById(UUID userId);
}
