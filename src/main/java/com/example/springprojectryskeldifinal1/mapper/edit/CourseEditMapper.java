package com.example.springprojectryskeldifinal1.mapper.edit;
import com.peaksoft.spring_boot.dto.request.CourseRequest;
import com.peaksoft.spring_boot.entity.Courses;
import com.peaksoft.spring_boot.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseEditMapper {

    private final CompanyRepository companyRepository;

    public Courses create(CourseRequest courseRequest, Long id) {
        if (courseRequest == null) {
            return null;
        }

        Courses course = new Courses();
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(course.getDuration());
        course.setCompany(companyRepository.findById(id).get());
        return course;
    }

    public void update(Courses course, CourseRequest courseRequest) {
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDurationMonth());
    }
}
