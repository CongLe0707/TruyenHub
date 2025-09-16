package com.example.TruyenHub.infras.repo;

import com.example.TruyenHub.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
