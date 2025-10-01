package com.example.TruyenHub.service.impl;

import com.example.TruyenHub.dto.req.CommonReq;
import com.example.TruyenHub.dto.req.CreateChapterComicReq;
import com.example.TruyenHub.dto.res.CreateChapterComicRes;
import com.example.TruyenHub.exception.DelegationServiceException;
import com.example.TruyenHub.infras.repo.ChapterComicRepository;
import com.example.TruyenHub.infras.repo.ComicRepository;
import com.example.TruyenHub.mapper.ChapterComicMapper;
import com.example.TruyenHub.model.entity.ChapterComic;
import com.example.TruyenHub.model.entity.ChapterImage;
import com.example.TruyenHub.model.entity.Comic;
import com.example.TruyenHub.model.enums.ResultCode;
import com.example.TruyenHub.service.ChapterComicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ChapterComicServiceImpl implements ChapterComicService {

    private final ChapterComicRepository chapterComicRepository;
    private final ComicRepository comicRepository;
    private final ChapterComicMapper chapterComicMapper;

    @Override
    public CreateChapterComicRes createChapterComic(CommonReq<CreateChapterComicReq> req) {
        CreateChapterComicReq data = req.getData();

        Comic comic = comicRepository.findByTitle(data.comicName())
                .orElseThrow(() -> new DelegationServiceException(
                        ResultCode.NO_COMIC_NAME.getCode(),
                        ResultCode.NO_COMIC_NAME.getMessage())
                );

        //Map từ dto sang enity
        ChapterComic chapterComic = chapterComicMapper.toEntity(data);
        chapterComic.setComic(comic);

        // build images
        List<ChapterImage> images = buildImages(data.imageUrls(), chapterComic);
        chapterComic.setImages(images);

        ChapterComic saved = chapterComicRepository.save(chapterComic);

        return new CreateChapterComicRes (
                saved.getId(),
                saved.getComic().getTitle(),
                saved.getTitle(),
                saved.getChapterNumber(),
                saved.getImages().stream()
                        .map(img -> new CreateChapterComicRes.ImageDto(
                                img.getId(),
                                img.getImageUrl(),
                                img.getPageNumber()
                        ))
                        .toList(),
                saved.getCreatedAt(),
                saved.getUpdatedAt()

        );
    }
    private List<ChapterImage> buildImages(List<String> imageUrls, ChapterComic chapter) {
        List<ChapterImage> images = new ArrayList<>();
        for (int i = 0; i < imageUrls.size(); i++) {
            ChapterImage img = new ChapterImage();
            img.setImageUrl(imageUrls.get(i));
            img.setPageNumber(i + 1);
            img.setChapterComic(chapter);
            images.add(img);
        }
        return images;
    }
}
