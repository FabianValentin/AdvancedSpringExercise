package com.elysian.advanced.spring.exercise.repositories.security;

import com.elysian.advanced.spring.exercise.models.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
