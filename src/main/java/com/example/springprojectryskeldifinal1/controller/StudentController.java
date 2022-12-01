package com.example.springprojectryskeldifinal1.controller;

import com.peaksoft.spring_boot.dto.request.StudentRequest;
import com.peaksoft.spring_boot.dto.response.StudentResponse;
import com.peaksoft.spring_boot.entity.Student;
import com.peaksoft.spring_boot.service.GroupService;
import com.peaksoft.spring_boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;
    private final GroupService groupService;

    @Autowired
    public StudentController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @GetMapping
    public List<Student> findAllStudent() {
        return studentService.getAllStudent();
    }



    @GetMapping("/{sort}")
    public String sortStudent(@PathVariable String sort) {
        return studentService.findStudentWithSort(sort).toString();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    public StudentResponse save(@Valid @PathVariable Long groupId, @RequestBody StudentRequest studentRequest) {
        return studentService.saveStudent(studentRequest, groupId);
    }

    @PutMapping("/update/{id}")
    public StudentResponse updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(studentRequest, id);
    }

    @GetMapping("/getById/{id}")
    public StudentResponse getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudentById(@PathVariable("id") Long id) {
        studentService.deleteStudentById(id);
    }
}
