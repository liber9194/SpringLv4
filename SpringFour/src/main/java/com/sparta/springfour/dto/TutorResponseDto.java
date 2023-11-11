package com.sparta.springfour.dto;

import com.sparta.springfour.entity.Tutor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TutorResponseDto {

    private Long id;
    private String tutorName;
    private Integer year;
    private String company;
    private String inform;

    public TutorResponseDto(Tutor tutor)
    {
        this.id = tutor.getId();
        this.tutorName = tutor.getTutorName();
        this.year = tutor.getYear();
        this.company = tutor.getCompany();
        this.inform = tutor.getInform();
    }
}
