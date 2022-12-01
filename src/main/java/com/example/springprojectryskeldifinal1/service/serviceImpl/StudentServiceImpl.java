package com.example.springprojectryskeldifinal1.service.serviceImpl;

import com.peaksoft.spring_boot.dto.request.StudentRequest;
import com.peaksoft.spring_boot.dto.response.StudentResponse;
import com.peaksoft.spring_boot.entity.Student;
import com.peaksoft.spring_boot.mapper.edit.StudentEditMapper;
import com.peaksoft.spring_boot.mapper.views.StudentViewMapper;
import com.peaksoft.spring_boot.repository.GroupsRepository;
import com.peaksoft.spring_boot.repository.StudentRepository;
import com.peaksoft.spring_boot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final GroupsRepository groupsRepository;
    private final StudentRepository studentRepository;
    private final StudentEditMapper studentEditMapper;
    private final StudentViewMapper studentViewMapper;

    @Override
    @Transactional
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public StudentResponse saveStudent(StudentRequest studentRequest, Long id) {
        return studentViewMapper.viewStudent(studentRepository.save(studentEditMapper.create(studentRequest, id)));
    }

    @Override
    @Transactional
    public StudentResponse updateStudent(StudentRequest studentRequest, Long id) {
        Student student = studentRepository.getById(id);
        studentEditMapper.update(student, studentRequest);
        return studentViewMapper.viewStudent(studentRepository.findById(id).get());
    }

    @Override
    @Transactional
    public StudentResponse getStudentById(Long id) {
        return studentViewMapper.viewStudent(studentRepository.findById(id).get());
    }

    @Override
    @Transactional
    public StudentResponse deleteStudentById(Long id) {
        Student student = studentRepository.getById(id);
        studentRepository.deleteById(id);
        return studentViewMapper.viewStudent(student);
    }

    @Override
    public Long countById(Long id) {
        return studentRepository.count();
    }

    @Override
    public Long countByIdT(Long id) {
        return studentRepository.countByIdT(id);
    }

    @Override
    public List<Student> findStudentWithSort(String sorting) {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC,sorting));
    }
}
