package com.grupp3.ooad_projekt_backend.repository;

import com.grupp3.ooad_projekt_backend.models.ERole;
import com.grupp3.ooad_projekt_backend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
