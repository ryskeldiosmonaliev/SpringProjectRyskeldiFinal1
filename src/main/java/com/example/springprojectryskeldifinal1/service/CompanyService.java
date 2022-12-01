package com.example.springprojectryskeldifinal1.service;

import com.peaksoft.spring_boot.dto.request.CompanyRequest;
import com.peaksoft.spring_boot.dto.response.CompanyResponse;
import com.peaksoft.spring_boot.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompany();

    CompanyResponse saveCompany(CompanyRequest companyRequest);

    CompanyResponse updateCompany(Long id, CompanyRequest companyRequest);

    CompanyResponse getCompanyById(Long id);

    void deleteCompanyById(Long id);
}
