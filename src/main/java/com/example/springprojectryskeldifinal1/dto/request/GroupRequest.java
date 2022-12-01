package com.example.springprojectryskeldifinal1.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GroupRequest {

    @NotNull
    private String groupName;
    @NotNull
    private String dateOfStart;
    @NotNull
    private  String dateOfFinish;
}
