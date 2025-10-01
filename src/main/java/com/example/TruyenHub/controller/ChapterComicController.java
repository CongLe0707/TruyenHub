package com.example.TruyenHub.controller;

import com.example.TruyenHub.dto.req.CommonReq;
import com.example.TruyenHub.dto.req.CreateChapterComicReq;
import com.example.TruyenHub.dto.req.CreateChapterReq;
import com.example.TruyenHub.dto.res.CommonRes;
import com.example.TruyenHub.service.ChapterComicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/chapter_comic")
public class ChapterComicController {
    private final ChapterComicService chapterComicService;

    @PostMapping("/create")
    public ResponseEntity<CommonRes> createChapterComic(@RequestBody CommonReq<CreateChapterComicReq> req) {
        return ApiHandler.handle(req,chapterComicService::createChapterComic);
    }
}
