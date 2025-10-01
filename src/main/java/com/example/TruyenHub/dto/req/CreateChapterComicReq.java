package com.example.TruyenHub.dto.req;

import java.util.List;

public record CreateChapterComicReq(
        String comicName,
        String title,
        Integer chapterNumber,
        List<String> imageUrls
) {
}
