package com.example.TruyenHub.service;

import com.example.TruyenHub.dto.req.CommonReq;
import com.example.TruyenHub.dto.req.CreateChapterComicReq;
import com.example.TruyenHub.dto.res.CreateChapterComicRes;

public interface ChapterComicService {
    CreateChapterComicRes createChapterComic (CommonReq<CreateChapterComicReq> req);
}
