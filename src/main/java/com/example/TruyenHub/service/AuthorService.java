package com.example.TruyenHub.service;

import com.example.TruyenHub.dto.req.AuthorReq;
import com.example.TruyenHub.dto.req.CommonReq;
import com.example.TruyenHub.dto.res.AuthorRes;

public interface AuthorService {
    AuthorRes createAuthor(CommonReq<AuthorReq> req);

}
