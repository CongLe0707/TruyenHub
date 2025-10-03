package com.example.TruyenHub.controller;

import com.example.TruyenHub.dto.req.CommonReq;
import com.example.TruyenHub.dto.req.CreateComicReq;
import com.example.TruyenHub.dto.res.CommonRes;
import com.example.TruyenHub.service.ComicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comic")
public class ComicController {

    private final ComicService comicService;

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CommonRes> createComic(@ModelAttribute CreateComicReq req) {
        return ApiHandler.handle(new CommonReq<>(req), comicService::createComic);
    }


    @GetMapping("/detail/{comicId}")
    public ResponseEntity<CommonRes> getComicDetail(@PathVariable UUID comicId) {
        return ApiHandler.handle(null, req -> comicService.detailComic(comicId));
    }

    @GetMapping("/list")
    public ResponseEntity<CommonRes> getAllComics() {
        return ApiHandler.handle(null,req -> comicService.listComic());
    }

}
