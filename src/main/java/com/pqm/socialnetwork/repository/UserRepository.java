package com.pqm.socialnetwork.repository;

import com.pqm.socialnetwork.model.user.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(@NotBlank String username);
    Optional<User> findUserByEmail(@NotBlank String email);
}
