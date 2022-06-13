package com.fabrizioserial.jibberjabber.DTO;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateDto {
    private String body;
    private String guidAuthor;
}
