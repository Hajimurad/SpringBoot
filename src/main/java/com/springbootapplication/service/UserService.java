package com.springbootapplication.service;

import com.springbootapplication.entity.User;
import java.util.List;

public interface UserService  {

    List<User> findAllUsers();

    void create(User user);
    void update(User user);
    void deleteById(Long id);

    User readById(Long id);
    User findByUsername(String name);
}

