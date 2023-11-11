package com.sparta.springfour.controller;

import com.sparta.springfour.dto.CommentRequestDto;
import com.sparta.springfour.entity.Comment;
import com.sparta.springfour.entity.User;
import com.sparta.springfour.entity.UserRoleEnum;
import com.sparta.springfour.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/api")
public class CommentController {

    private CommentService commentService;

    @PostMapping("/course/comments")
    public ResponseEntity<Comment> registerComment (@RequestBody CommentRequestDto requestDto,
                                                   @AuthenticationPrincipal User user)
    {
        Comment comment = commentService.registerComment(requestDto, user);

        try{
            return ResponseEntity.ok(comment);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "댓글을 작성을 실패했습니다.");
        }
    }

    @PutMapping("/course/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto,
                                                @AuthenticationPrincipal User user)
    {
        Comment comment = commentService.updateComment(id,requestDto,user);
        try {
            return ResponseEntity.ok(comment);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "댓글을 수정을 실패했습니다.");
        }
    }

    @DeleteMapping("/course/comments/{id}")
    public ResponseEntity<Object> deleteComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto,
                                                @AuthenticationPrincipal User user)
    {
        try{
            commentService.deleteComment(id, requestDto, user);
        } catch (Exception e) {
            return new ResponseEntity<>("댓글 삭제를 실패했습니다.",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("댓글 삭제를 성공했습니다.",HttpStatus.OK);
    }
}
