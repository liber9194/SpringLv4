package com.sparta.springfour.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import com.sparta.springfour.entity.Comment;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private String text;

    public CommentResponseDto(Comment comment)
    {
        this.text = comment.getText();
    }
}
