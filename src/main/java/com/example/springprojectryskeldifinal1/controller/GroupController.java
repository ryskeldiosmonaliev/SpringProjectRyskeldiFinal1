package com.example.springprojectryskeldifinal1.controller;

import com.peaksoft.spring_boot.dto.request.GroupRequest;
import com.peaksoft.spring_boot.dto.response.GroupResponse;
import com.peaksoft.spring_boot.entity.Groups;
import com.peaksoft.spring_boot.service.CourseService;
import com.peaksoft.spring_boot.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    private final CourseService courserService;
    private final GroupService groupService;

    @Autowired
    public GroupController(CourseService courserService, GroupService groupService) {
        this.courserService = courserService;
        this.groupService = groupService;
    }

    @GetMapping
    public List<Groups> getAllGroups() {
        return groupService.getAllGroup();
    }

    @GetMapping("/{id}")
    public GroupResponse findByIdGroups(@PathVariable Long id) {
        return groupService.getGroupById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    public GroupResponse saveGroups(@Valid @RequestBody GroupRequest group, @PathVariable Long teacherId) {
        return groupService.saveGroup(group,teacherId);
    }

    @PutMapping("/update/{id}")
    public GroupResponse updateGroup(@PathVariable Long id, @RequestBody GroupRequest groupRequest) {
        return groupService.updateGroup(id, groupRequest);
    }

    @GetMapping("/search")
    public String searchStudent(@RequestParam("student") String search) {
        return groupService.findByStudents(search).toString();


    }

    @DeleteMapping("/delete/{id}")
    public void deleteGroupsById(@PathVariable("id") Long id) {
        groupService.deleteGroupById(id);
    }
}
