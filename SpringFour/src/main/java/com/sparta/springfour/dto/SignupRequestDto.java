package com.sparta.springfour.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {
    @Email(message = "이메일 형식을 맞추어 주세요")
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private String gender;
    private String phoneNumber;
    private String address;
    private boolean admin = false;
    private String adminToken = "";
}