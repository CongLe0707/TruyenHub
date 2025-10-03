package com.example.TruyenHub.service;

import com.example.TruyenHub.dto.req.CommonReq;
import com.example.TruyenHub.dto.req.CreateChapterReq;
import com.example.TruyenHub.dto.res.CreateChapterRes;
import com.example.TruyenHub.dto.res.DetailChapterStoryRes;

import java.util.UUID;

public interface ChapterService {

    CreateChapterRes createChapter (CommonReq<CreateChapterReq> req);

    DetailChapterStoryRes detailChapterStory (UUID id);
}
