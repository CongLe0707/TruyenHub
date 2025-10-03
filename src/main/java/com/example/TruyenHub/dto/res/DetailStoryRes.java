package com.example.TruyenHub.dto.res;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record DetailStoryRes (
        UUID id,
        String title,
        String description,
        String categoriName,
        String authorName,
        LocalDateTime createdAt,
        List<ChapterStoryDto> chapterStoryDtos
) {
    public record ChapterStoryDto (
            UUID id,
            Integer numberChapter,
            String title,
            LocalDateTime createdAt
    ) {}
}
