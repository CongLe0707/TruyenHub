package com.example.TruyenHub.service;

import com.example.TruyenHub.dto.req.CommonReq;
import com.example.TruyenHub.dto.req.CreateChapterReq;
import com.example.TruyenHub.dto.res.CreateChapterRes;

public interface ChapterService {
    CreateChapterRes createChapter (CommonReq<CreateChapterReq> req);
}
