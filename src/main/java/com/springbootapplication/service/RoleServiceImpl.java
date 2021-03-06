package com.springbootapplication.service;

import com.springbootapplication.dao.RoleDAO;
import com.springbootapplication.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleDAO roleDAO;

    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public Set<Role> findAllRoles(){
        return roleDAO.findAllRoles();
    }

    @Override
    @Transactional(readOnly = true)
    public Role readById(Long id) {
       return roleDAO.readById(id);
    }

    @Override
    public void create(Role role) {
        roleDAO.create(role);
    }

    public Set<Role> rolesSetFromArray(Long[] roleArr) {

        Set<Role> roles = new HashSet<>();

        for (Long id : roleArr) {
            roles.add(readById(id));
        }
        return roles;
    }
}
