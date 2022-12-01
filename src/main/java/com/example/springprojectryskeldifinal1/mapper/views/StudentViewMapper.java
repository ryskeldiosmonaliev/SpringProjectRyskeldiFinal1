package com.example.springprojectryskeldifinal1.mapper.views;

import com.peaksoft.spring_boot.dto.response.StudentResponse;
import com.peaksoft.spring_boot.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentViewMapper {

    public StudentResponse viewStudent(Student student) {
        if (student == null) {
            return null;
        }

        StudentResponse studentResponse = new StudentResponse();
        if (student.getId() != null) {
            studentResponse.setId(student.getId());
        }
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setLastName(student.getLastName());
        studentResponse.setEmail(student.getEmail());
        System.out.println("Student ViewMapper");
        return studentResponse;
    }
}
