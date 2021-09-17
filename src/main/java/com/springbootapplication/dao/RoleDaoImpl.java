package com.springbootapplication.dao;

import com.springbootapplication.entity.Role;
import com.springbootapplication.entity.User;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDAO {

    public RoleDaoImpl() {
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role readById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Set<Role> findAllRoles() {
        return new HashSet<>(entityManager.createQuery("FROM Role", Role.class).getResultList());
    }

    @Override
    public void create(Role role) {
        entityManager.persist(role);
    }
}
