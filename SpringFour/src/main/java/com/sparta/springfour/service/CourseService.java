package com.sparta.springfour.service;

import com.sparta.springfour.dto.*;
import com.sparta.springfour.entity.Comment;
import com.sparta.springfour.entity.Course;
import com.sparta.springfour.entity.Tutor;
import com.sparta.springfour.entity.User;
import com.sparta.springfour.repository.CommentRepository;
import com.sparta.springfour.repository.CourseRepository;
import com.sparta.springfour.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TutorRepository tutorRepository;
    private final CommentRepository commentRepository;
    public CourseResponseDto registerCourse(CourseRequestDto requestDto)
    {
        Course course = new Course(requestDto);
        Course saveCourse = courseRepository.save(course);
        return new CourseResponseDto(saveCourse);
    }

    public CourseResponseDto searchCourse(Long id, TutorRequestDto tutorRequestDto)
    {
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("선택한 강의가 존재하지 않습니다.")
        );

        return new CourseResponseDto(course);
    }

    public List<CourseResponseDto> categoryCourse(String courseCategory)
    {
        List<CourseResponseDto> responseDtoList = new ArrayList<>();

        //원하는 기준에 따라 정렬
        List<Course> courseList = courseRepository.findAllByCourseCategoryOrderByCreatedAtDesc(courseCategory);


        for(Course course : courseList)
        {
            responseDtoList.add(new CourseResponseDto(course));
        }

        return responseDtoList;
    }

    public void likeCourse(Long id, LikeRequestDto requestDto, User user)
    {
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당하는 강의가 존재하지 않습니다.")
        );
        
        //좋아요가 되어있지않은 상태
        if(requestDto.isLikeCourse())
        {
            user.setLikeCourse(false);
            course.setLikeNumber(course.getLikeNumber()+1);
        }
        //좋아요가 되어있는 상태
        else
        {
            user.setLikeCourse(true);
            course.setLikeNumber(course.getLikeNumber()-1);
        }
    }

}
