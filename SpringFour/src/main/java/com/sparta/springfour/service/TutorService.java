package com.sparta.springfour.service;

import com.sparta.springfour.dto.CourseResponseDto;
import com.sparta.springfour.dto.TutorRequestDto;
import com.sparta.springfour.dto.TutorResponseDto;
import com.sparta.springfour.entity.Course;
import com.sparta.springfour.entity.Tutor;
import com.sparta.springfour.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorService {
    private final TutorRepository tutorRepository;

    public TutorResponseDto registerTutor(TutorRequestDto requestDto)
    {
        Tutor tutor = new Tutor(requestDto);
        Tutor saveTutor = tutorRepository.save(tutor);
        return new TutorResponseDto(saveTutor);
    }
    public TutorResponseDto getTutor(Long id)
    {
        Tutor tutor = tutorRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당하는 강사가 없습니다.")
        );

        return new TutorResponseDto(tutor);
    }

}
