package com.example.TruyenHub.controller;

import com.example.TruyenHub.dto.req.CommonReq;
import com.example.TruyenHub.dto.req.CreateChapterComicReq;
import org.springframework.http.MediaType;

import com.example.TruyenHub.dto.res.CommonRes;
import com.example.TruyenHub.service.ChapterComicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/chapter_comic")
public class ChapterComicController {
    private final ChapterComicService chapterComicService;

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CommonRes> createChapterComic(
            @RequestParam String comicName,
            @RequestParam String title,
            @RequestParam Integer chapterNumber,
            @RequestParam("imageUrls") MultipartFile[] files
    ) {
        CreateChapterComicReq data = new CreateChapterComicReq(comicName, title, chapterNumber, files);
        return ApiHandler.handle(new CommonReq<>(data), chapterComicService::createChapterComic);
    }

    @GetMapping("/detail/{chapterId}")
    public ResponseEntity<CommonRes> getChapterDetail(@PathVariable UUID chapterId) {
        return ApiHandler.handle(null, req -> chapterComicService.detailChapterComic(chapterId));
    }


}
