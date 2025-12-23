package com.example.apirest.repository;

import com.example.apirest.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    // CRUD automatique
}

