package com.springbootapplication;

import com.springbootapplication.entity.Role;
import com.springbootapplication.entity.User;
import com.springbootapplication.service.RoleService;
import com.springbootapplication.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class PostInit {

    private final UserService userService;
    private final RoleService roleService;

    public PostInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void afterPropertiesSet() {

        roleService.create(new Role("ADMIN"));
        roleService.create(new Role("USER"));

        User user = new User();
        user.setFirstName("User_name");
        user.setLastName("UserLastName");
        user.setUsername("user@gmail.com");
        user.setAge(50);
        user.setPassword("qwerty");
        user.setRoles(Set.of(roleService.readById(2L)));
        userService.create(user);

        User admin = new User();
        admin.setFirstName("Admin_name");
        admin.setLastName("AdminLastName");
        admin.setUsername("admin@gmail.com");
        admin.setAge(100);
        admin.setPassword("password");
        admin.setRoles(Set.of(roleService.readById(1L)));
        userService.create(admin);
    }
}
