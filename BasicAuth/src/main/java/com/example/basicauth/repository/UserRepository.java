package com.example.basicauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.basicauth.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String pass);
    User findByUsername(String username);
}
