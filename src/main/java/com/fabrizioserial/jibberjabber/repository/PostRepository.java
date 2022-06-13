package com.fabrizioserial.jibberjabber.repository;

import com.fabrizioserial.jibberjabber.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

}
