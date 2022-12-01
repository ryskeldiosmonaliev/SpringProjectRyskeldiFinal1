package com.example.springprojectryskeldifinal1.service;

import com.peaksoft.spring_boot.dto.request.CourseRequest;
import com.peaksoft.spring_boot.dto.response.CourseResponse;
import com.peaksoft.spring_boot.entity.Courses;

import java.util.List;

public interface CourseService {

    List<Courses> getAllCourse();

    CourseResponse saveCourse(CourseRequest courseRequest, Long id);

    CourseResponse updateCourse(Long id, CourseRequest courseRequest);

    CourseResponse getCourseById(Long id);

    void deleteCourseById(Long id);

}
