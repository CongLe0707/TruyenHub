package com.example.TruyenHub.dto.res;

import com.example.TruyenHub.model.entity.ChapterComic;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ComicDetailRes (
        UUID id,
        String title,
        String description,
        String coverImage,
        String category,
        String author,
        LocalDateTime createdAt,
        List<ChapterComicDto> chapterComic
){
    public record ChapterComicDto(
            UUID id,
            String title,
            LocalDateTime createdAt
    ) {}
}
