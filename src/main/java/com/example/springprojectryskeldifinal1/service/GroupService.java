package com.example.springprojectryskeldifinal1.service;

import com.peaksoft.spring_boot.dto.request.GroupRequest;
import com.peaksoft.spring_boot.dto.response.GroupResponse;
import com.peaksoft.spring_boot.entity.Groups;
import com.peaksoft.spring_boot.entity.Student;

import java.util.List;

public interface GroupService {

    List<Groups> getAllGroup();

    GroupResponse saveGroup(GroupRequest groupRequest, Long id);

    GroupResponse updateGroup(Long id, GroupRequest groupRequest);

    GroupResponse getGroupById(Long id);

    void deleteGroupById(Long id);
    List<Student> findByStudents(String  search);


}
