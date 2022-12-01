package com.example.springprojectryskeldifinal1.mapper.edit;

import com.peaksoft.spring_boot.dto.request.CompanyRequest;
import com.peaksoft.spring_boot.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyEditMapper {

    public Company create(CompanyRequest companyRequest) {
        if (companyRequest == null) {
            return null;
        }

        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        return company;
    }

    public void update(Company company, CompanyRequest companyRequest) {
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());

    }
}
