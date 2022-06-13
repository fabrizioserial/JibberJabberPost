package com.fabrizioserial.jibberjabber.DTO;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikesPostDto {
    UUID user;
    UUID post;
}
