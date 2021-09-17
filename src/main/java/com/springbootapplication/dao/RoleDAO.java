package com.springbootapplication.dao;

import com.springbootapplication.entity.Role;
import com.springbootapplication.entity.User;

import java.util.Set;

public interface RoleDAO {

    Set<Role> findAllRoles();
    void create(Role role);
    Role readById(Long id);
}
