package com.example.springprojectryskeldifinal1.service.serviceImpl;

import com.peaksoft.spring_boot.dto.request.TeacherRequest;
import com.peaksoft.spring_boot.dto.response.TeacherResponse;
import com.peaksoft.spring_boot.entity.Teacher;
import com.peaksoft.spring_boot.mapper.edit.TeacherEditMapper;
import com.peaksoft.spring_boot.mapper.views.TeacherViewMapper;
import com.peaksoft.spring_boot.repository.TeacherRepository;
import com.peaksoft.spring_boot.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherEditMapper teacherEditMapper;
    private final TeacherViewMapper teacherViewMapper;

    @Override
    @Transactional
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    @Transactional
    public TeacherResponse saveTeacher(TeacherRequest teacherRequest, Long id) {
        return teacherViewMapper.viewTeacher(teacherRepository.save(teacherEditMapper.create(teacherRequest, id)));
    }

    @Override
    @Transactional
    public TeacherResponse updateTeacher(TeacherRequest teacherRequest, Long id) {
        Teacher teacher = teacherRepository.getById(id);
        teacherEditMapper.update(teacher, teacherRequest);
        return teacherViewMapper.viewTeacher(teacherRepository.findById(id).get());
    }

    @Override
    @Transactional
    public TeacherResponse getTeacherById(Long id) {
        return teacherViewMapper.viewTeacher(teacherRepository.getById(id));
    }

    @Override
    @Transactional
    public TeacherResponse deleteTeacherById(Long id) {
        Teacher teacher = teacherRepository.getById(id);
        teacherRepository.deleteById(id);
        return teacherViewMapper.viewTeacher(teacher);
    }
}
