package com.example.springprojectryskeldifinal1.service.serviceImpl;

import com.peaksoft.spring_boot.dto.request.CourseRequest;
import com.peaksoft.spring_boot.dto.response.CourseResponse;
import com.peaksoft.spring_boot.entity.Courses;
import com.peaksoft.spring_boot.mapper.edit.CourseEditMapper;
import com.peaksoft.spring_boot.mapper.views.CourseViewMapper;
import com.peaksoft.spring_boot.repository.CoursesRepository;
import com.peaksoft.spring_boot.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CoursesRepository repository;
    private final CourseEditMapper editMapper;
    private final CourseViewMapper viewMapper;

    @Override
    @Transactional
    public List<Courses> getAllCourse() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public CourseResponse saveCourse(CourseRequest courseRequest, Long id) {
        return viewMapper.viewCourse(repository.save(editMapper.create(courseRequest, id)));
    }

    @Override
    @Transactional
    public CourseResponse updateCourse(Long id, CourseRequest courseRequest) {
        Courses course = repository.findById(id).get();
        editMapper.update(course, courseRequest);
        return viewMapper.viewCourse(repository.findById(id).get());
    }

    @Override
    @Transactional
    public CourseResponse getCourseById(Long id) {
        return viewMapper.viewCourse(repository.findById(id).get());
    }

    @Override
    public void deleteCourseById(Long id) {
        repository.deleteById(id);
    }
}
