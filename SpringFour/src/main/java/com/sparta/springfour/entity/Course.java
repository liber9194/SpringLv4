package com.sparta.springfour.entity;

import com.sparta.springfour.dto.CourseRequestDto;
import com.sparta.springfour.dto.TutorRequestDto;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String courseName;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String courseInform;

    @Column(nullable = false)
    private String courseCategory;

    @Column
    private LocalDateTime createdAt;

    @Column
    private Integer likeNumber;

    @OneToMany(mappedBy = "course")
    private Set<Comment> comments = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @ManyToMany
    @JoinTable(name = "course_like",
    joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> userList = new ArrayList<>();

    public Course(CourseRequestDto requestDto)
    {
        this.courseName = requestDto.getCourseName();
        this.price = requestDto.getPrice();
        this.courseInform = requestDto.getCourseInform();
        this.courseCategory = requestDto.getCourseCategory();
        this.createdAt = requestDto.getCreatedAt();
        this.likeNumber = requestDto.getLikeNumber();
        this.comments = requestDto.getComments();
    }

}