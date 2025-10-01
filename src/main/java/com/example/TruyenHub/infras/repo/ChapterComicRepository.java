package com.example.TruyenHub.infras.repo;

import com.example.TruyenHub.model.entity.ChapterComic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChapterComicRepository extends JpaRepository<ChapterComic, UUID> {
}
