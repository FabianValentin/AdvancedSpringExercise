package com.elysian.advanced.spring.exercise.repositories.security;

import com.elysian.advanced.spring.exercise.models.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
