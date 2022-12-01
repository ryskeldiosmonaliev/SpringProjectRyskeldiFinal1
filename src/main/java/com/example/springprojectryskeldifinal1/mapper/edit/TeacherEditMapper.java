package com.example.springprojectryskeldifinal1.mapper.edit;

import com.peaksoft.spring_boot.dto.request.TeacherRequest;
import com.peaksoft.spring_boot.entity.Teacher;
import com.peaksoft.spring_boot.repository.CoursesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TeacherEditMapper {

    private final CoursesRepository courseRepository;

    public Teacher create(TeacherRequest teacherRequest, Long id) {
        if (teacherRequest == null) {
            return null;
        }

        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setLastName(teacherRequest.getLastName());
        teacher.setCourses(courseRepository.findById(id).get());
        return teacher;
    }

    public void update(Teacher teacher, TeacherRequest teacherRequest) {
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setLastName(teacherRequest.getLastName());
    }
}
