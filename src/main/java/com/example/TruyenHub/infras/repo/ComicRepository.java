package com.example.TruyenHub.infras.repo;

import com.example.TruyenHub.model.entity.Comic;
import com.example.TruyenHub.model.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ComicRepository extends JpaRepository<Comic, UUID> {
    Optional<Comic> findByTitle(String title);

}
