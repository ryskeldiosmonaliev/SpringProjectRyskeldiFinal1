package com.example.springprojectryskeldifinal1.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class StudentRequest {

    @NotNull
    private String firstName;
    @NotNull
    private String email;
    @NotNull
    private String lastName;


}
