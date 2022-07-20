package com.fabrizioserial.jibberjabber.repository;

import com.fabrizioserial.jibberjabber.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    Page<Post> findAllByUserId(UUID userId, Pageable pageable);
}
