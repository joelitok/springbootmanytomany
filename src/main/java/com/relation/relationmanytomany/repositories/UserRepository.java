package com.relation.relationmanytomany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relation.relationmanytomany.entities.User;

public interface UserRepository extends JpaRepository<User,String>{
    User findByUsername(String username);
}

