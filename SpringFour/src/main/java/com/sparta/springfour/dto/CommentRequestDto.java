package com.sparta.springfour.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    private Long courseId;
    private String text;
    private Long userId;
}
