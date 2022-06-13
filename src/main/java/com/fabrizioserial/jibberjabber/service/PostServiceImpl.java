package com.fabrizioserial.jibberjabber.service;

import com.fabrizioserial.jibberjabber.DTO.LikesPostDto;
import com.fabrizioserial.jibberjabber.DTO.PostCreateDto;
import com.fabrizioserial.jibberjabber.DTO.UpdatePostDto;
import com.fabrizioserial.jibberjabber.exception.PostNotFoundException;
import com.fabrizioserial.jibberjabber.model.Post;
import com.fabrizioserial.jibberjabber.repository.PostRepository;
import lombok.val;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository ){
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts(){
//        Post post = new Post();
//        post.setBody("Hola como estas");
//        post.setLikes(0);
//        post.setGuidAuthor("123212423");
//        post.setUuid(UUID.randomUUID());
//        post.setTimeAdded(LocalDate.of(2001, Month.APRIL,11) );
        return postRepository.findAll();
    }

    @Override
    public void deletePost(UUID uuid) {
        if (postRepository.existsById(uuid)) {
            postRepository.deleteById(uuid);
        }
    }

    @Override
    public Post getPostByUuid(UUID uuid) {
        return postRepository.findById(uuid).orElse(null);
    }

    @Override
    public Post updatePost(UpdatePostDto updatePostDto, UUID uuid) {
        val postFound = postRepository.findById(uuid);
        if(postFound.isEmpty()) throw new PostNotFoundException(String.format("There is any post with id %s", uuid));
        val post = postFound.get();
        post.setBody(updatePostDto.getBody());
        return post;
    }

    @Override
    public Post likesPost(LikesPostDto likesPostDto) {
        val postFound = postRepository.findById(likesPostDto.getPost());
        if(postFound.isEmpty()) throw new PostNotFoundException(String.format("There is any post with id %s", likesPostDto.getPost()));
        List<UUID> newListOfLikes = postFound.get().getLikes();
        newListOfLikes.add(likesPostDto.getUser());
        postFound.get().setLikes(newListOfLikes);
        return postRepository.save(postFound.get());
    }

    public Post createPost(PostCreateDto postCreateDto){
        Post post = Post.builder()
                .body(postCreateDto.getBody())
                .likes(List.of())
                .guidAuthor(postCreateDto.getGuidAuthor())
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .build();

        return postRepository.save(post);
    }


}
