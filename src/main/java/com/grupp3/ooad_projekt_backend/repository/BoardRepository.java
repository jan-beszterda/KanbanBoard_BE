package com.grupp3.ooad_projekt_backend.repository;

import com.grupp3.ooad_projekt_backend.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}