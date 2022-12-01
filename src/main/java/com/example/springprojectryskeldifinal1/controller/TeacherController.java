package com.example.springprojectryskeldifinal1.controller;

import com.peaksoft.spring_boot.dto.request.TeacherRequest;
import com.peaksoft.spring_boot.dto.response.TeacherResponse;
import com.peaksoft.spring_boot.entity.Teacher;
import com.peaksoft.spring_boot.service.StudentService;
import com.peaksoft.spring_boot.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;
    private final StudentService studentService;


    @GetMapping
    public List<Teacher> findAllTeacher() {
        return teacherService.getAllTeacher();
    }

    @GetMapping("/{id}")
    public TeacherResponse getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    public TeacherResponse create(@Valid @RequestBody TeacherRequest teacherRequest, @PathVariable Long courseId) {
        return teacherService.saveTeacher(teacherRequest, courseId);}

    @PatchMapping("/update/{id}")
    public TeacherResponse updateTeacher(@PathVariable Long id, @RequestBody TeacherRequest teacherRequest) {
        return teacherService.updateTeacher(teacherRequest, id);}
    //localhost:9090/api/teacher/count/1  бир мугалимдин канча студенти бар айди менен мугалимдин
    @GetMapping("/count/{id}")
    public Long countByIdT(@PathVariable("id") Long id) {
        teacherService.getTeacherById(id);
        return studentService.countByIdT(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTeacherById(@PathVariable("id") Long id) {
        teacherService.deleteTeacherById(id);
    }
}
