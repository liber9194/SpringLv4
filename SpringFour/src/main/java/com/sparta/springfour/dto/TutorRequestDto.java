package com.sparta.springfour.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TutorRequestDto {
    private Long id;
    private String tutorName;
    private Integer year;
    private String company;
    private String phoneNumber;
    private String inform;
}
