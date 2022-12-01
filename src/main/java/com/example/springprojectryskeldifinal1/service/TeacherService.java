package com.example.springprojectryskeldifinal1.service;

import com.peaksoft.spring_boot.dto.request.TeacherRequest;
import com.peaksoft.spring_boot.dto.response.TeacherResponse;
import com.peaksoft.spring_boot.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeacher();

    TeacherResponse saveTeacher(TeacherRequest teacherRequest, Long id);

    TeacherResponse updateTeacher(TeacherRequest teacherRequest, Long id);

    TeacherResponse getTeacherById(Long id);

    TeacherResponse deleteTeacherById(Long id);
}
