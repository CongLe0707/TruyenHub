package com.example.TruyenHub.dto.res;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


public record CreateChapterComicRes (
        UUID id,
        String ComicName,
        String title,
        Integer chapterNumber,
        List<ImageDto> images ,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public record ImageDto (
            UUID id,
            String imageUrl,
            Integer pageNumber
    ) {}
}
