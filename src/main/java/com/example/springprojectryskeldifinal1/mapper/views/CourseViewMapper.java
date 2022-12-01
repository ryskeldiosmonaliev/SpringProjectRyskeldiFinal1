package com.example.springprojectryskeldifinal1.mapper.views;

import com.peaksoft.spring_boot.dto.response.CourseResponse;
import com.peaksoft.spring_boot.entity.Courses;
import org.springframework.stereotype.Component;


@Component
public class CourseViewMapper {

    public CourseResponse viewCourse(Courses course) {
        if (course == null) {
            return null;
        }

        CourseResponse response = new CourseResponse();
        if (course.getId() != null) {
            response.setId(course.getId());
        }

        response.setCourseName(course.getCourseName());
        response.setDurationMonth(course.getDuration());
        System.out.println("Course View Mapper");
        return response;
    }
}
