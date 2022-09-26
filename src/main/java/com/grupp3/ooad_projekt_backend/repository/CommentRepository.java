package com.grupp3.ooad_projekt_backend.repository;

import com.grupp3.ooad_projekt_backend.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
