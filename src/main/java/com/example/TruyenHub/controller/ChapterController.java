package com.example.TruyenHub.controller;

import com.example.TruyenHub.dto.req.CategoryReq;
import com.example.TruyenHub.dto.req.CommonReq;
import com.example.TruyenHub.dto.req.CreateChapterReq;
import com.example.TruyenHub.dto.res.CommonRes;
import com.example.TruyenHub.service.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/chapter")
public class ChapterController {
    private  final ChapterService chapterService;

    @PostMapping("/create")
    public ResponseEntity<CommonRes> createChapter(@RequestBody CommonReq<CreateChapterReq> req) {
        return ApiHandler.handle(req,chapterService::createChapter);
    }
}
