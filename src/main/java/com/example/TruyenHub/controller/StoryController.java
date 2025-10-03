package com.example.TruyenHub.controller;


import com.example.TruyenHub.dto.req.CommonReq;
import com.example.TruyenHub.dto.req.CreateStoryReq;
import com.example.TruyenHub.dto.res.CommonRes;
import com.example.TruyenHub.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Reader;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/story")
public class StoryController {

    private  final StoryService storyService;


    @PostMapping("/create")
    public ResponseEntity<CommonRes> createNovel(@RequestBody CommonReq<CreateStoryReq> req) {
        return ApiHandler.handle(req, storyService::createNovel);
    }

    @GetMapping("/list")
    public ResponseEntity<CommonRes> GetAllStory() {
        return ApiHandler.handle(null, req -> storyService.listStory());
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<CommonRes> GetDetail(@PathVariable UUID id) {
        return ApiHandler.handle(null, req -> storyService.detailStory(id));
    }
}
