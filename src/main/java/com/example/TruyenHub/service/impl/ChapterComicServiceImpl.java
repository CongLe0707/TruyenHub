package com.example.TruyenHub.service.impl;

import com.example.TruyenHub.dto.req.CommonReq;
import com.example.TruyenHub.dto.req.CreateChapterComicReq;
import com.example.TruyenHub.dto.res.CreateChapterComicRes;
import com.example.TruyenHub.exception.DelegationServiceException;
import com.example.TruyenHub.infras.repo.ChapterComicRepository;
import com.example.TruyenHub.infras.repo.ChapterImageRepository;
import com.example.TruyenHub.infras.repo.ComicRepository;
import com.example.TruyenHub.mapper.ChapterComicMapper;
import com.example.TruyenHub.model.entity.ChapterComic;
import com.example.TruyenHub.model.entity.ChapterImage;
import com.example.TruyenHub.model.entity.Comic;
import com.example.TruyenHub.model.enums.ResultCode;
import com.example.TruyenHub.service.ChapterComicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ChapterComicServiceImpl implements ChapterComicService {

    private final ChapterImageRepository chapterImageRepository;
    private final ChapterComicRepository chapterComicRepository;
    private final ComicRepository comicRepository;
    private final ChapterComicMapper chapterComicMapper;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public CreateChapterComicRes createChapterComic(CommonReq<CreateChapterComicReq> req) {
        CreateChapterComicReq data = req.getData();

        Comic comic = comicRepository.findByTitle(data.comicName())
                .orElseThrow(() -> new DelegationServiceException(
                        ResultCode.NO_COMIC_NAME.getCode(),
                        ResultCode.NO_COMIC_NAME.getMessage())
                );

        if (chapterComicRepository.existsByComicAndChapterNumber(comic, data.chapterNumber())) {
            throw new DelegationServiceException(
                    ResultCode.DUPLICATE_CHAPTER.getCode(),
                    ResultCode.DUPLICATE_CHAPTER.getMessage()
            );
        }

        if (chapterComicRepository.existsByComicAndTitle(comic, data.title())) {
            throw new DelegationServiceException(
                    ResultCode.DUPLICATE_CHAPTER_NAME.getCode(),
                    ResultCode.DUPLICATE_CHAPTER_NAME.getMessage()
            );
        }

        ChapterComic chapterComic = chapterComicMapper.toEntity(data);
        chapterComic.setComic(comic);

        ChapterComic saved = chapterComicRepository.save(chapterComic);

        List<ChapterImage> images = buildImages(data.imageUrls(), saved, comic.getId(), data.chapterNumber());
        saved.setImages(images);

        // Save lại sau khi gắn images
        ChapterComic finalSaved = chapterComicRepository.save(saved);

        return new CreateChapterComicRes(
                finalSaved.getId(),
                finalSaved.getComic().getTitle(),
                finalSaved.getTitle(),
                finalSaved.getChapterNumber(),
                finalSaved.getImages().stream()
                        .map(img -> new CreateChapterComicRes.ImageDto(
                                img.getId(),
                                img.getImageUrl(),
                                img.getPageNumber()
                        ))
                        .toList(),
                finalSaved.getCreatedAt(),
                finalSaved.getUpdatedAt()
        );
    }

    private String saveFile(MultipartFile file, String folderName) throws IOException {
        Path folderPath = Paths.get(uploadDir, folderName);
        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }

        String fileName = UUID.randomUUID() + "_" + Objects.requireNonNull(file.getOriginalFilename());
        Path filePath = folderPath.resolve(fileName);

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return "/uploads/ChapterComic/" + folderName + "/" + fileName;
    }

    private List<ChapterImage> buildImages(MultipartFile[] files, ChapterComic chapter, UUID comicId, Integer chapterNumber) {
        List<ChapterImage> images = new ArrayList<>();
        Set<String> uploadedNames = new HashSet<>();

        for (int i = 0; i < files.length; i++) {
            try {
                MultipartFile file = files[i];

                // Check duplicate filename trong request
                if (!uploadedNames.add(file.getOriginalFilename())) {
                    throw new DelegationServiceException(
                            ResultCode.DUPLICATE_IMAGE.getCode(),
                            ResultCode.DUPLICATE_IMAGE.getMessage()
                    );
                }

                String folderName = "chapter_comic_" + chapterNumber;
                String filePath = saveFile(file, folderName);

                // Check duplicate path trong DB
                if (chapterImageRepository.existsByChapterComicAndImageUrl(chapter, filePath)) {
                    throw new DelegationServiceException(
                            ResultCode.DUPLICATE_IMAGE.getCode(),
                            ResultCode.DUPLICATE_IMAGE.getMessage()
                    );
                }

                ChapterImage img = new ChapterImage();
                img.setImageUrl(filePath);
                img.setPageNumber(i + 1);
                img.setChapterComic(chapter);
                images.add(img);

            } catch (IOException e) {
                throw new RuntimeException("Lỗi lưu file: " + files[i].getOriginalFilename(), e);
            }
        }
        return chapterImageRepository.saveAll(images);
    }
}
