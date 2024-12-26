package com.sitrc.connektify.user_service.repository;

import com.sitrc.connektify.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

   Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}