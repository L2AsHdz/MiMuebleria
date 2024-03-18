package com.ayd2.mimuebleria.repository;

import com.ayd2.mimuebleria.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
