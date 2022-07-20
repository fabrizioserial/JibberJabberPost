package com.fabrizioserial.jibberjabber.DTO;

import com.fabrizioserial.jibberjabber.model.Reply;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReplyDto {

    private UUID id;

    private String text;

    private UserDto user;

    private List<ReplyDto> thread;

    public static List<ReplyDto> from(List<Reply> replies) {
        List<ReplyDto> replyDto = new ArrayList<>();
        replies.forEach(reply -> replyDto.add(ReplyDto.builder()
                .id(reply.getId())
                .text(reply.getContent())
                .user(UserDto.from(reply.getUser()))
                .build()));
        return replyDto;
    }
}