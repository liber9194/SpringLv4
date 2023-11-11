package com.sparta.springfour.dto;

import lombok.Getter;
import lombok.Setter;
import com.sparta.springfour.entity.Comment;
import org.intellij.lang.annotations.Pattern;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class CourseRequestDto {
    private String courseName;
    private Integer price;
    private String courseInform;
    private String courseCategory;
    private String tutorName;
    private LocalDateTime createdAt;
    private Integer likeNumber;
    private Set<Comment> comments;
}
