package com.grupp3.ooad_projekt_backend.repository;

import com.grupp3.ooad_projekt_backend.models.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {
}
