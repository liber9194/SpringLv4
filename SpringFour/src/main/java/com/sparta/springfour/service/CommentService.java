package com.sparta.springfour.service;

import com.sparta.springfour.dto.CommentRequestDto;
import com.sparta.springfour.dto.CommentResponseDto;
import com.sparta.springfour.entity.Comment;
import com.sparta.springfour.entity.Course;
import com.sparta.springfour.entity.User;
import com.sparta.springfour.repository.CommentRepository;
import com.sparta.springfour.repository.CourseRepository;
import com.sparta.springfour.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public Comment registerComment(CommentRequestDto requestDto, User user)
    {
        Comment comment = new Comment();

        Course course = courseRepository.findById(requestDto.getCourseId()).orElseThrow(
                () -> new IllegalArgumentException("해당하는 강의가 존재하지 않습니다.")
        );

        comment.setText(requestDto.getText());
        comment.setCourse(course);
        comment.setUser(user);
        comment.setCreatedDate(LocalDateTime.now());

        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id, CommentRequestDto requestDto, User user)
    {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당하는 댓글이 존재하지 않습니다.")
        );

        comment.update(requestDto);

        return comment;
    }

    public void deleteComment(Long id, CommentRequestDto requestDto, User user)
    {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다.")
        );

        commentRepository.delete(comment);
    }
}
