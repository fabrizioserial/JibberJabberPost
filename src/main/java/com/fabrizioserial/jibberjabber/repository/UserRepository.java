package com.fabrizioserial.jibberjabber.repository;

import com.fabrizioserial.jibberjabber.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);

    User findAllByUsernameContainingOrDisplayNameContaining(String username, String displayName);
}
