package com.sparta.springfour.controller;

import com.sparta.springfour.dto.CourseResponseDto;
import com.sparta.springfour.dto.TutorRequestDto;
import com.sparta.springfour.dto.TutorResponseDto;
import com.sparta.springfour.entity.Tutor;
import com.sparta.springfour.entity.User;
import com.sparta.springfour.entity.UserRoleEnum;
import com.sparta.springfour.service.TutorService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class TutorController {
    private TutorService tutorService;

    @Secured(UserRoleEnum.Authority.ADMIN)
    @PostMapping("/tutor")
    public TutorResponseDto registerTutor(@RequestBody TutorRequestDto requestDto,
                                          @AuthenticationPrincipal User user)
    {
        return tutorService.registerTutor(requestDto);
    }

}
