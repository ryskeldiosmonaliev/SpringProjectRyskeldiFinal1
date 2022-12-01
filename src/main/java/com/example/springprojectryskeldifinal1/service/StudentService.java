package com.example.springprojectryskeldifinal1.service;

import com.peaksoft.spring_boot.dto.request.StudentRequest;
import com.peaksoft.spring_boot.dto.response.StudentResponse;
import com.peaksoft.spring_boot.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();

    StudentResponse saveStudent(StudentRequest studentRequest, Long id);

    StudentResponse updateStudent(StudentRequest studentRequest, Long id);

    StudentResponse getStudentById(Long id);

    StudentResponse deleteStudentById(Long id);
    Long countById(Long id);
    Long countByIdT(Long id);
    List<Student> findStudentWithSort(String sorting);
}
