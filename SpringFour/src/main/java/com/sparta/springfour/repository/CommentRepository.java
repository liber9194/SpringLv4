package com.sparta.springfour.repository;

import com.sparta.springfour.entity.Comment;
import com.sparta.springfour.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    Set<Comment> findByCourseId(Long courseId);
}
