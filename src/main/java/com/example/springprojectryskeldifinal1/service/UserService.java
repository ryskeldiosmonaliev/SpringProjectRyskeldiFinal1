package com.example.springprojectryskeldifinal1.service;

import com.peaksoft.spring_boot.entity.User;

import java.util.List;

public interface UserService {

        User save(User user);

        User findById(Long id);

        List<User> findAll();

        void delete(Long id);

        User update(Long id, User newUser);
    }


