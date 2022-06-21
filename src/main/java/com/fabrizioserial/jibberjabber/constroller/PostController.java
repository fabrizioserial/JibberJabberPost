package com.fabrizioserial.jibberjabber.constroller;

import com.fabrizioserial.jibberjabber.DTO.LikesPostDto;
import com.fabrizioserial.jibberjabber.DTO.PostCreateDto;
import com.fabrizioserial.jibberjabber.DTO.UpdatePostDto;
import com.fabrizioserial.jibberjabber.model.Post;
import com.fabrizioserial.jibberjabber.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/post/")
public class PostController {

    @Autowired
    private final PostServiceImpl postService;

    public PostController(PostServiceImpl postService){
        this.postService = postService;
    }

    @GetMapping(path = "getall")
    public ResponseEntity<List<Post>> getAllPosts(){
        //        return ResponseEntity.status(HttpStatus.OK).body(todos);
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
    }

    @GetMapping(path = "get/{uuid}")
    public ResponseEntity<Post> getPostByUuid(@PathVariable UUID uuid){
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostByUuid(uuid));
    }

    @PostMapping(path = "create")
    public ResponseEntity<Post> createPost(@RequestBody PostCreateDto postCreateDto){
        return ResponseEntity.status(HttpStatus.OK).body(postService.createPost(postCreateDto));
    }

    @PostMapping(path = "likes")
    public ResponseEntity<Post> likesPost(@RequestBody LikesPostDto likesPostDto){
        return ResponseEntity.status(HttpStatus.OK).body(postService.likesPost(likesPostDto));
    }

    @PostMapping(path = "update/{uuid}")
    public ResponseEntity<Post> updatePost(@PathVariable UUID uuid, @RequestBody UpdatePostDto updatePostDto){
        return ResponseEntity.status(HttpStatus.OK).body(postService.updatePost(updatePostDto, uuid));
    }

    @DeleteMapping(path = "delete/{uuid}")
    public ResponseEntity<?> deletePost(@PathVariable UUID uuid){
        postService.deletePost(uuid);
        return ResponseEntity.noContent().build();
    }

}
