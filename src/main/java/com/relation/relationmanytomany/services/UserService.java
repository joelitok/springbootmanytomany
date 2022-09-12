package com.relation.relationmanytomany.services;

import com.relation.relationmanytomany.entities.Role;
import com.relation.relationmanytomany.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String username);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username,String roleName);
    User authenticate(String username, String password);
    
}
