package com.grupp3.ooad_projekt_backend.repository;

import com.grupp3.ooad_projekt_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardRepository extends JpaRepository<User, Long> {

}