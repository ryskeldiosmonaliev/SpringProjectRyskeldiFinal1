package com.example.springprojectryskeldifinal1.mapper.edit;

import com.peaksoft.spring_boot.dto.request.StudentRequest;
import com.peaksoft.spring_boot.entity.Student;
import com.peaksoft.spring_boot.repository.GroupsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentEditMapper {

    private final GroupsRepository groupRepository;

    public Student create(StudentRequest studentRequest, Long id) {
        if (studentRequest == null) {
            return null;
        }

        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setGroups(groupRepository.getById(id));
        return student;
    }

    public void update(Student student, StudentRequest studentRequest) {
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
    }
}
