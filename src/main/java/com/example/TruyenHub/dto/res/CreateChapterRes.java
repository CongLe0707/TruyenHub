package com.example.TruyenHub.dto.res;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateChapterRes(
        UUID id,
        String storyName,
        String title,
        Integer chapterNumber,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
