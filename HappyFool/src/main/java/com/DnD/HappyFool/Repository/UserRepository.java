package com.DnD.HappyFool.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DnD.HappyFool.Domain.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Optional <User> findByEmail(String email);
}
