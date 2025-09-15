package com.example.TruyenHub.mapper;


import com.example.TruyenHub.dto.req.CategoryReq;
import com.example.TruyenHub.dto.res.CategoryRes;
import com.example.TruyenHub.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    Category toEntity(CategoryReq dto);
}
