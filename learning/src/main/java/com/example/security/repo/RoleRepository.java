package com.example.security.repo;

import com.example.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
