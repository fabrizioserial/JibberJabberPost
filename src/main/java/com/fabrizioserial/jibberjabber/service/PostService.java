package com.fabrizioserial.jibberjabber.service;

import com.fabrizioserial.jibberjabber.DTO.*;
import com.fabrizioserial.jibberjabber.model.Post;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface PostService {

    PostDto createPost(PostCreationDto postCreationDto);

    PostDto getPost(UUID postId);

    Page<PostDto> getPostsByUser(UUID userId, int page, int size);

    PostDto createReply(UUID postId, ReplyCreationDto replyCreationDto);

    void deletePost(UUID postId);

    Page<PostDto> getAllPosts(int page, int size);
}
