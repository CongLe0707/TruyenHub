package com.example.TruyenHub.dto.res;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ChapterComicDetailRes(
        UUID id,
        String title,
        Integer chapterNumber,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<ImageDto> images
) {
    public record ImageDto(
            UUID id,
            String imageUrl,
            Integer pageNumber
    ) {}
}
