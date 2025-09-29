package com.example.TruyenHub.mapper;

import com.example.TruyenHub.dto.req.CreateChapterReq;
import com.example.TruyenHub.model.entity.Chapter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChapterMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "story", ignore = true) // set trong service
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    Chapter toEntity(CreateChapterReq req);
}
