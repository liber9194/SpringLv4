package com.sparta.springfour.entity;

import com.sparta.springfour.dto.CourseRequestDto;
import com.sparta.springfour.dto.TutorRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tutors")
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String tutorName;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String inform;

    public Tutor(TutorRequestDto requestDto) {
        this.tutorName = requestDto.getTutorName();
        this.year = requestDto.getYear();
        this.company = requestDto.getCompany();
        this.phoneNumber = requestDto.getPhoneNumber();
        this.inform = requestDto.getInform();
    }

}
