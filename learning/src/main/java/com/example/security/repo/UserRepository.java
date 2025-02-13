package com.example.security.repo;


import com.example.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
