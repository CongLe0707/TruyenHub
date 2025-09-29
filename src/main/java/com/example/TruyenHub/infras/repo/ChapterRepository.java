package com.example.TruyenHub.infras.repo;

import com.example.TruyenHub.model.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChapterRepository extends JpaRepository<Chapter, UUID> {
}
