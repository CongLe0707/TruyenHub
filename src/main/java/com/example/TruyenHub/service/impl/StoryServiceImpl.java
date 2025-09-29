package com.example.TruyenHub.service.impl;

import com.example.TruyenHub.dto.req.CommonReq;
import com.example.TruyenHub.dto.req.CreateStoryReq;
import com.example.TruyenHub.dto.res.CreateStoryRes;
import com.example.TruyenHub.exception.DelegationServiceException;
import com.example.TruyenHub.infras.repo.AuthorRepository;
import com.example.TruyenHub.infras.repo.CategoryRepository;
import com.example.TruyenHub.infras.repo.StoryRepository;
import com.example.TruyenHub.mapper.StoryMapper;
import com.example.TruyenHub.model.entity.Author;
import com.example.TruyenHub.model.entity.Category;
import com.example.TruyenHub.model.entity.Story;
import com.example.TruyenHub.model.enums.ResultCode;
import com.example.TruyenHub.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final StoryMapper storyMapper;


    @Override
    public CreateStoryRes createStory(CommonReq<CreateStoryReq> req) {
        CreateStoryReq data = req.getData();
        Author author = authorRepository.findByName(data.authorName())
                .orElseThrow(() -> new DelegationServiceException(
                        ResultCode.NO_AUTHOR.getCode(),
                        ResultCode.NO_AUTHOR.getMessage())
                );
        Category category = categoryRepository.findByName(data.categoriName())
                .orElseThrow(() -> new DelegationServiceException(
                        ResultCode.NO_CATEGORY.getCode(),
                        ResultCode.NO_CATEGORY.getMessage())
                );
        Story story = storyMapper.toEntity(data);
        story.setAuthor(author);
        story.setCategory(category);
        story.setCreatedAt(LocalDateTime.now());
        story.setUpdatedAt(LocalDateTime.now());

        Story saved = storyRepository.save(story);


        return new  CreateStoryRes (
                saved.getId(),
                saved.getTitle(),
                saved.getDescription(),
                saved.getCategory().getName(),
                saved.getAuthor().getName(),
                saved.getCreatedAt()

        );
    }
}
