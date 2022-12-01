package com.example.springprojectryskeldifinal1.controller;

import com.peaksoft.spring_boot.dto.request.CourseRequest;
import com.peaksoft.spring_boot.dto.response.CourseResponse;
import com.peaksoft.spring_boot.entity.Courses;
import com.peaksoft.spring_boot.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CoursesController {

    private final CourseService courserService;

    @GetMapping
    public List<Courses> findAllCourses() {
        return courserService.getAllCourse();
    }

    @GetMapping("/{id}")
    public CourseResponse findById(@PathVariable Long id) {
        return courserService.getCourseById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    public CourseResponse saveCourses(@RequestBody CourseRequest courseRequest, @PathVariable Long companyId) {
        return courserService.saveCourse(courseRequest, companyId);
    }

    @PatchMapping("/update/{id}")
    public CourseResponse updateCourse(@PathVariable Long id, @RequestBody CourseRequest courseRequest) {
       return courserService.updateCourse(id,courseRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCoursesById(@PathVariable Long id) {
        courserService.deleteCourseById(id);
    }
}
