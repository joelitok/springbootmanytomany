package com.relation.relationmanytomany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relation.relationmanytomany.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}

