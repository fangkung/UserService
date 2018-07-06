package com.fds.poramin.userservice.service;

import com.fds.poramin.userservice.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    User findByUsername(String username);

    List<User> findAll();

}
