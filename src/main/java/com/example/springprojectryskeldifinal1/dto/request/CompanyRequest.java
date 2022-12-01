package com.example.springprojectryskeldifinal1.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRequest {

    @NotNull
    private String companyName;
    @NotNull
    private String locatedCountry;

}
