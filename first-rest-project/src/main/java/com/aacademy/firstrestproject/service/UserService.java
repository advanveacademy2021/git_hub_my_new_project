package com.aacademy.firstrestproject.service;

import com.aacademy.firstrestproject.model.User;

import java.util.Set;

public interface UserService {

    User findById(Long id);

    Set<User> findAll();

    User save(User user);

    User update (User user);

    User update(Long id, User user);

    void  delete(Long id);

    void delete (String name);
}
