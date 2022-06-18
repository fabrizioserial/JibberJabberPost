package com.fabrizioserial.jibberjabber.service;

import com.fabrizioserial.jibberjabber.DTO.UserDTO;
import com.fabrizioserial.jibberjabber.model.User;

import java.util.UUID;

public interface UserService {
    UserDTO getLoggedUser();

    UserDTO getUser(UUID userId);

    UserDTO searchUser(String searchUser);

    User getCurrentUser();

    User getUserById(UUID userId);
}
