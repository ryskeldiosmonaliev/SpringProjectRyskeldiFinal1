package com.example.springprojectryskeldifinal1.mapper.views;

import com.peaksoft.spring_boot.dto.response.GroupResponse;
import com.peaksoft.spring_boot.entity.Groups;
import org.springframework.stereotype.Component;

@Component
public class GroupViewMapper {

    public GroupResponse viewGroup(Groups group) {
        if (group == null) {
            return null;
        }

        GroupResponse groupResponse = new GroupResponse();
        if (group.getId() != null) {
            groupResponse.setId(group.getId());
        }

        groupResponse.setGroupName(group.getGroupName());
        groupResponse.setDateOfFinish(group.getDateOfFinish());
        groupResponse.setDateOfStart(group.getDateOfStart());
        System.out.println("Group ViewMapper ");
        return groupResponse;
    }
}
