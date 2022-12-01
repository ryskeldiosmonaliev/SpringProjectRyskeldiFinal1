package com.example.springprojectryskeldifinal1.mapper.edit;

import com.peaksoft.spring_boot.dto.request.GroupRequest;
import com.peaksoft.spring_boot.entity.Courses;
import com.peaksoft.spring_boot.entity.Groups;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class GroupEditMapper {

    public Groups create(GroupRequest groupRequest, Courses id) {
        if (groupRequest == null) {
            return null;
        }

        Groups group = new Groups();
        group.setGroupName(groupRequest.getGroupName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        group.setDateOfFinish(groupRequest.getDateOfFinish());
        group.setCourse(id);
        return group;

    }

    public void update(Groups group, GroupRequest groupRequest) {
        group.setGroupName(groupRequest.getGroupName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        group.setDateOfFinish(groupRequest.getDateOfFinish());    }
}
