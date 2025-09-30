package com.example.TruyenHub.controller;

import com.example.TruyenHub.dto.req.CommonReq;
import com.example.TruyenHub.dto.req.CreateComicReq;
import com.example.TruyenHub.dto.req.CreateStoryReq;
import com.example.TruyenHub.dto.res.CommonRes;
import com.example.TruyenHub.service.ComicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comic")
public class ComicController {

    private final ComicService comicService;

    @PostMapping("/create")
    public ResponseEntity<CommonRes> createComic(@RequestBody CommonReq<CreateComicReq> req) {
        return ApiHandler.handle(req, comicService::createComic);
    }

}
