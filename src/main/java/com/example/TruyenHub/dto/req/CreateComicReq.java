package com.example.TruyenHub.dto.req;

public record CreateComicReq (
        String title,
        String description,
        String coverImage,
        String categoriName,
        String authorName

) {
}
