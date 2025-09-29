package com.example.TruyenHub.dto.req;

import com.example.TruyenHub.model.entity.Author;
import com.example.TruyenHub.model.entity.Category;
import com.example.TruyenHub.model.entity.Chapter;

public record CreateStoryReq (
        String title,
        String description,
        String coverImage,
        String categoriName,
        String authorName

) {
}
