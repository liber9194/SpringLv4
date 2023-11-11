package com.sparta.springfour.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestDto {
    @Email(message = "이메일 형식을 맞추어 주세요")
    private String email;
    private String password;
}