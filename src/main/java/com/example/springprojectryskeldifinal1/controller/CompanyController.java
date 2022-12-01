package com.example.springprojectryskeldifinal1.controller;

import com.peaksoft.spring_boot.dto.request.CompanyRequest;
import com.peaksoft.spring_boot.dto.response.CompanyResponse;
import com.peaksoft.spring_boot.entity.Company;
import com.peaksoft.spring_boot.service.CompanyService;
import com.peaksoft.spring_boot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;
    private final StudentService studentService;

    @GetMapping
    public List<Company> findAllCompany() {
        return companyService.getAllCompany();
    }

    @GetMapping("/{id}")
    public CompanyResponse findById(@PathVariable  Long id) {
        return companyService.getCompanyById(id);
    }
    //localhost:9090/api/company/count канча студенти бар
    @GetMapping("/count")
    public Long countById(Long id){
        return studentService.countById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    public CompanyResponse saveCompany(@RequestBody CompanyRequest companyRequest) {
        return companyService.saveCompany(companyRequest);
    }

    @PatchMapping("update/{id}")
    public CompanyResponse updateCompany(@PathVariable Long id, @RequestBody CompanyRequest companyRequest) {
        return companyService.updateCompany(id,companyRequest);
    }

    @DeleteMapping("delete/{id}")
    public void deleteCompanyById(@PathVariable("id") Long id) {
        companyService.deleteCompanyById(id);
    }
}

