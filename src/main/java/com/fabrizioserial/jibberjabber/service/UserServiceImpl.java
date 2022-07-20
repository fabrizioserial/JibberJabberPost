package com.fabrizioserial.jibberjabber.service;

import com.fabrizioserial.jibberjabber.DTO.UserDto;
import com.fabrizioserial.jibberjabber.model.User;
import com.fabrizioserial.jibberjabber.repository.UserRepository;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getLoggedUser() {
        User user = getCurrentUser();
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .displayName(user.getDisplayName())
                .bio(user.getBio())
                .avatar(user.getAvatar())
                .build();
    }

    @Override
    public User getCurrentUser() {
        KeycloakPrincipal principal = (KeycloakPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        AccessToken accessToken = session.getToken();
        String username = accessToken.getPreferredUsername();

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            User newUser = User.builder()
                    .id(UUID.randomUUID())
                    .username(username)
                    .displayName(username)
                    .bio("")
                    .build();
            return userRepository.save(newUser);
        }
        return user.get();
    }

    @Override
    public User getUserById(UUID userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserDto getUser(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .displayName(user.getDisplayName())
                .bio(user.getBio())
                .avatar(user.getAvatar())
                .build();
    }

    @Override
    public UserDto searchUser(String searchUser) {
        User user = userRepository.findAllByUsernameContainingOrDisplayNameContaining(searchUser, searchUser);
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .displayName(user.getDisplayName())
                .bio(user.getBio())
                .avatar(user.getAvatar())
                .build();
    }

}
