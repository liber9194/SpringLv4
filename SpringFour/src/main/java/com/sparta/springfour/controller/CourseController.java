package com.sparta.springfour.controller;

import com.sparta.springfour.dto.CourseRequestDto;
import com.sparta.springfour.dto.CourseResponseDto;
import com.sparta.springfour.dto.LikeRequestDto;
import com.sparta.springfour.dto.TutorRequestDto;
import com.sparta.springfour.entity.User;
import com.sparta.springfour.entity.UserRoleEnum;
import com.sparta.springfour.security.UserDetailsImpl;
import com.sparta.springfour.service.CourseService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class CourseController {
    private CourseService courseService;

    /*
    @GetMapping("/courses")
    public String getCourse(@AuthenticationPrincipal UserDetailsImpl userDetails)
    {
        //Authentication의 principle
        //유저 detail 가져오기
        User user = userDetails.getUser();
        System.out.println("user.getEmail "+ user.getEmail());
        return "redirect:/";
    }*/

    @Secured(UserRoleEnum.Authority.ADMIN)
    @PostMapping("/course")
    public CourseResponseDto registerCourse(@RequestBody CourseRequestDto requestDto,
                                            @AuthenticationPrincipal User user) {
        // 카테고리는 3개 뿐
        return courseService.registerCourse(requestDto);
    }

    @GetMapping("/course/{id}")
    public CourseResponseDto searchCourse(@PathVariable Long id,
                                          @RequestBody TutorRequestDto tutorRequestDto)
    {
        return courseService.searchCourse(id, tutorRequestDto);
    }

    @GetMapping("/courses/{courseCategory}")
    public List<CourseResponseDto> categoryCourse(@PathVariable String courseCategory)
    {
        return courseService.categoryCourse(courseCategory);
    }

    @GetMapping("/course/{id}/like")
    public ResponseEntity<Object> likeCourse(@PathVariable Long id, @RequestBody LikeRequestDto requestDto,
                                             @AuthenticationPrincipal User user)
    {
        try {
            courseService.likeCourse(id, requestDto, user);
        } catch (Exception e){
            return new ResponseEntity("좋아요를 누르기를 실패했습니다.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("해당 강의에 좋아요를 눌렀습니다.", HttpStatus.OK);
    }

/*
    @PostMapping("/validation")
    @ResponseBody
    public ProductRequestDto testValid(HttpServletRequest req, @RequestBody @Valid ProductRequestDto requestDto)
    {
        User user = (User) req.getAttribute("user");

        return requestDto;
    }

    @Secured(UserRoleEnum.Authority.ADMIN) // 관리자용
    @GetMapping("/products/secured")
    public String getProductsByAdmin(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        System.out.println("userDetails.getUsername() = " + userDetails.getUsername());
        for (GrantedAuthority authority : userDetails.getAuthorities()) {
            System.out.println("authority.getAuthority() = " + authority.getAuthority());
        }

        return "redirect:/";
    }
*/
}