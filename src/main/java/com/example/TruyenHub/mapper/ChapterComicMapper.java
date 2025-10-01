package com.example.TruyenHub.mapper;

import com.example.TruyenHub.dto.req.CreateChapterComicReq;
import com.example.TruyenHub.model.entity.ChapterComic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChapterComicMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "comic", ignore = true)    // sẽ set thủ công trong service
    @Mapping(target = "images", ignore = true)   // xử lý riêng
    ChapterComic toEntity(CreateChapterComicReq req);
}
