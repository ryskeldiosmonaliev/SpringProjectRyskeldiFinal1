package com.example.springprojectryskeldifinal1.service.serviceImpl;

import com.peaksoft.spring_boot.dto.request.GroupRequest;
import com.peaksoft.spring_boot.dto.response.GroupResponse;
import com.peaksoft.spring_boot.entity.Courses;
import com.peaksoft.spring_boot.entity.Groups;
import com.peaksoft.spring_boot.entity.Student;
import com.peaksoft.spring_boot.mapper.edit.GroupEditMapper;
import com.peaksoft.spring_boot.mapper.views.GroupViewMapper;
import com.peaksoft.spring_boot.repository.CoursesRepository;
import com.peaksoft.spring_boot.repository.GroupsRepository;
import com.peaksoft.spring_boot.repository.StudentRepository;
import com.peaksoft.spring_boot.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupsRepository groupRepository;
    private final GroupEditMapper groupEditMapper;
    private final GroupViewMapper groupViewMapper;
    private final CoursesRepository courseRepository;
    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public List<Groups> getAllGroup() {
        return groupRepository.findAll();
    }

    @Override
    @Transactional
    public GroupResponse saveGroup(GroupRequest groupRequest, Long id) {
        Courses course = courseRepository.getById(id);
        return groupViewMapper.viewGroup(groupRepository.save(groupEditMapper.create(groupRequest, course)));
    }

    @Override
    @Transactional
    public GroupResponse updateGroup(Long id, GroupRequest groupRequest) {
        Groups group = groupRepository.getById(id);
        groupEditMapper.update(group, groupRequest);
        return groupViewMapper.viewGroup(groupRepository.findById(id).get());
    }

    @Override
    @Transactional
    public GroupResponse getGroupById(Long id) {
        return groupViewMapper.viewGroup(groupRepository.findById(id).get());
    }

    @Override
    @Transactional
    public void deleteGroupById(Long id) {
        groupRepository.deleteById(id);

    }

    @Override
    public List<Student> findByStudents(String search) {
        if (search !=null){
            return groupRepository.findByStudents(search);
        }
        return  studentRepository.findAll();
    }
}
