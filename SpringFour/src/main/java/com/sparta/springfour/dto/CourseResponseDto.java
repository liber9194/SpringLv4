package com.sparta.springfour.dto;

import com.sparta.springfour.entity.Comment;
import com.sparta.springfour.entity.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@NoArgsConstructor
public class CourseResponseDto {
    private Long id;
    private String courseName;
    private Integer price;
    private String courseInform;
    private String courseCategory;
    private LocalDateTime createdAt;

    private String tutorName;
    private Integer year;
    private String company;
    private String inform;

    private Set<Comment> comments;

    public CourseResponseDto(Course course)
    {
        this.id = course.getId();
        this.courseName = course.getCourseName();
        this.price = course.getPrice();
        this.courseInform = course.getCourseInform();
        this.courseCategory = course.getCourseCategory();
        this.createdAt = course.getCreatedAt();
        this.tutorName = course.getTutor().getTutorName();
        this.year = course.getTutor().getYear();
        this.company = course.getTutor().getCompany();
        this.inform = course.getTutor().getInform();
        this.comments = course.getComments();
    }
}
