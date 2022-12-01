package com.example.springprojectryskeldifinal1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "groups")
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinTable(name = "groups_courses", joinColumns = @JoinColumn(name = "groups_id")
            , inverseJoinColumns = @JoinColumn(name = "courses_id"))
    @JsonIgnore
    private List<Courses> courses;
    @Transient
    private Long courseId;

    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.REFRESH},mappedBy = "groups")
    private List<Student> students;

    public void setCourse(Courses course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
        course.setGroup(this);
    }
    @Override
    public String toString() {
        return "Groups{" +
                "id=" + id;
    }

}
