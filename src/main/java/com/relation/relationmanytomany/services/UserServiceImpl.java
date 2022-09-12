package com.relation.relationmanytomany.services;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.relation.relationmanytomany.entities.Role;
import com.relation.relationmanytomany.entities.User;
import com.relation.relationmanytomany.repositories.RoleRepository;
import com.relation.relationmanytomany.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;


    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
    
    User user = findUserByUserName(username);
    Role role = findRoleByRoleName(roleName);
    if(user.getRoles()!=null){
    user.getRoles().add(role);
    role.getUsers().add(user);
    }
    //userRepository.save(user);
    }

    @Override
    public User authenticate(String username, String password) {
        User user =userRepository.findByUsername(username);
        if(user==null) throw new RuntimeException("Bad credentials");
       
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad Credentials");
    }
    
}
