package com.sparta.springfour.repository;

import com.sparta.springfour.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByCourseCategoryOrderByCourseNameDesc(String courseCategory);
    List<Course> findAllByCourseCategoryOrderByPriceDesc(String courseCategory);
    List<Course> findAllByCourseCategoryOrderByCreatedAtDesc(String courseCategory);
    List<Course> findAllByCourseCategoryOrderByCourseNameAsc(String courseCategory);
    List<Course> findAllByCourseCategoryOrderByPriceAsc(String courseCategory);
    List<Course> findAllByCourseCategoryOrderByCreatedAtAsc(String courseCategory);
}
