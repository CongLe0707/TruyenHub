package com.example.TruyenHub.dto.req;



public record CreateChapterReq (
        String storyName,
        String title,
        Integer chapterNumber,
        String content
) {
}
