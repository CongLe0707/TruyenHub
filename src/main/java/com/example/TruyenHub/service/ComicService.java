package com.example.TruyenHub.service;

import com.example.TruyenHub.dto.req.CommonReq;
import com.example.TruyenHub.dto.req.CreateComicReq;
import com.example.TruyenHub.dto.res.ComicDetailRes;
import com.example.TruyenHub.dto.res.CommonRes;
import com.example.TruyenHub.dto.res.CreateComicRes;

import java.util.UUID;

public interface ComicService {

    CreateComicRes createComic(CommonReq<CreateComicReq> req);

    ComicDetailRes detailComic(UUID comicId);

}
