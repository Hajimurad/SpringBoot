package com.springbootapplication.dao;

import com.springbootapplication.entity.User;
import java.util.List;

public interface UserDAO {

    List<User> findAllUsers();

    void create(User user);
    void update(User user);
    void deleteById(Long id);

    User readById(Long id);
    User findByUsername(String name);
}
