package com.fabrizioserial.jibberjabber.service;

import com.fabrizioserial.jibberjabber.DTO.LikesPostDto;
import com.fabrizioserial.jibberjabber.DTO.PostCreateDto;
import com.fabrizioserial.jibberjabber.DTO.UpdatePostDto;
import com.fabrizioserial.jibberjabber.model.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {

    Post createPost(PostCreateDto postCreateDto);

    List<Post> getAllPosts();

    void deletePost(UUID uuid);

    Post getPostByUuid(UUID uuid);
    
    Post likesPost(LikesPostDto likesPostDto);

    Post updatePost(UpdatePostDto updatePostDto, UUID uuid);
}
