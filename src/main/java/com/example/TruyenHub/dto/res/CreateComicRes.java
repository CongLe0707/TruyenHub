package com.example.TruyenHub.dto.res;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateComicRes (
        UUID id,
        String title,
        String description,
        String categoriName,
        String authorName,
        LocalDateTime createdAt
) {
}
