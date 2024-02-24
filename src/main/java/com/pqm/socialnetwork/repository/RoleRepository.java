package com.pqm.socialnetwork.repository;

import com.pqm.socialnetwork.model.role.Role;
import com.pqm.socialnetwork.model.role.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}