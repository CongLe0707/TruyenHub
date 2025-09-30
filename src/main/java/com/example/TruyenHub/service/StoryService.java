package com.example.TruyenHub.service;

import com.example.TruyenHub.dto.req.CommonReq;
import com.example.TruyenHub.dto.req.CreateStoryReq;
import com.example.TruyenHub.dto.res.CreateStoryRes;

public interface StoryService {
    CreateStoryRes createNovel(CommonReq<CreateStoryReq> req);
}
