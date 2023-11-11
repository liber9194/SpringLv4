package com.sparta.springfour.controller;

import com.sparta.springfour.dto.LoginRequestDto;
import com.sparta.springfour.dto.SignupRequestDto;
import com.sparta.springfour.entity.User;
import com.sparta.springfour.   service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }
    @GetMapping("/user/login-page")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/user/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/user/signup")
    public ResponseEntity<String> signup(@Valid SignupRequestDto requestDto, BindingResult bindingResult){
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        if(fieldErrors.size() > 0) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                log.error(fieldError.getField() + " 필드 : " + fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>("redirect:/api/user/signup",HttpStatus.BAD_REQUEST);
        }

        try {
            userService.signup(requestDto);
        } catch (Exception e) {
            return new ResponseEntity("redirect:/",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("redirect:/api/user/login-page",HttpStatus.OK);
    }

    @PostMapping("/user/login")
    public ResponseEntity<String> login(@Valid LoginRequestDto requestDto, HttpServletResponse res) {

        try{
            userService.login(requestDto, res);
        } catch (Exception e) {
            return new ResponseEntity("redirect:/",HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("redirect:/api/user/login-page",HttpStatus.OK);
    }
}