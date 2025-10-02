package com.example.TruyenHub.dto.req;

import org.springframework.web.multipart.MultipartFile;



public record CreateChapterComicReq(
        String comicName,
        String title,
        Integer chapterNumber,
        MultipartFile[] imageUrls
) {
}
