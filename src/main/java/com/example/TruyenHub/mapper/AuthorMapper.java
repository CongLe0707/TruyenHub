package com.example.TruyenHub.mapper;

import com.example.TruyenHub.dto.req.AuthorReq;
import com.example.TruyenHub.dto.res.AuthorRes;
import com.example.TruyenHub.model.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "name", target = "name")
    @Mapping(source = "bio", target = "bio")
    Author toEntity (AuthorReq req);
}
