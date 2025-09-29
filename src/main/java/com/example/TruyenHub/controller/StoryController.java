package com.example.TruyenHub.controller;


import com.example.TruyenHub.dto.req.CommonReq;
import com.example.TruyenHub.dto.req.CreateStoryReq;
import com.example.TruyenHub.dto.res.CommonRes;
import com.example.TruyenHub.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/story")
public class StoryController {
    private  final StoryService storyService;
    @PostMapping("/create")
    public ResponseEntity<CommonRes> createStory(@RequestBody CommonReq<CreateStoryReq> req) {
        return ApiHandler.handle(req,storyService::createStory);
    }
}
