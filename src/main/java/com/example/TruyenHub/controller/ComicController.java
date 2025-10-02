package com.example.TruyenHub.controller;

import com.example.TruyenHub.dto.req.CommonReq;
import com.example.TruyenHub.dto.req.CreateComicReq;
import com.example.TruyenHub.dto.res.CommonRes;
import com.example.TruyenHub.service.ComicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comic")
public class ComicController {

    private final ComicService comicService;

    @PostMapping("/create")
    public ResponseEntity<CommonRes> createComic(@RequestBody CommonReq<CreateComicReq> req) {
        return ApiHandler.handle(req, comicService::createComic);
    }

    @GetMapping("/detail/{comicId}")
    public ResponseEntity<CommonRes> getComicDetail(@PathVariable UUID comicId) {
        return ApiHandler.handle(null, req -> comicService.detailRes(comicId));
    }

}
