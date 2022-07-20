package com.fabrizioserial.jibberjabber.DTO;

import com.fabrizioserial.jibberjabber.model.Post;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostDto {

    private UUID id;

    private String text;

    private UserDto user;

    private List<ReplyDto> thread;

    public static PostDto from(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .text(post.getContent())
                .user(UserDto.from(post.getUser()))
                .thread(ReplyDto.from(post.getReplies()))
                .build();
    }
}