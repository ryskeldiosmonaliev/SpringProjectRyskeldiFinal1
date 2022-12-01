package com.example.springprojectryskeldifinal1.mapper.views;

import com.peaksoft.spring_boot.dto.response.TeacherResponse;
import com.peaksoft.spring_boot.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherViewMapper {

    public TeacherResponse viewTeacher(Teacher teacher) {
        if (teacher == null) {
            return null;
        }

        TeacherResponse teacherResponse = new TeacherResponse();
        if (teacher.getId() != null) {
            teacherResponse.setId(teacher.getId());
        }
        teacherResponse.setFirstName(teacher.getFirstName());
        teacherResponse.setLastName(teacher.getLastName());
        teacherResponse.setEmail(teacher.getEmail());
        return teacherResponse;
    }
}
