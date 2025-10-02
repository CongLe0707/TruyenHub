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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ChapterComicServiceImpl implements ChapterComicService {

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

        // Map từ dto sang entity
        ChapterComic chapterComic = chapterComicMapper.toEntity(data);
        chapterComic.setComic(comic);

        // build images từ files
        List<ChapterImage> images = buildImages(data.imageUrls(), chapterComic, comic.getId(), data.chapterNumber());
        chapterComic.setImages(images);

        ChapterComic saved = chapterComicRepository.save(chapterComic);

        return new CreateChapterComicRes(
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

    // Lưu 1 file xuống thư mục uploads/chapters/{folderName}
    private String saveFile(MultipartFile file, String folderName) throws IOException {
        Path folderPath = Paths.get(uploadDir, folderName);
        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = folderPath.resolve(fileName);

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // Trả về relative path
        return "/uploads/ChapterComic/" + folderName + "/" + fileName;
    }

    // Build list images từ mảng file
    private List<ChapterImage> buildImages(MultipartFile[] files, ChapterComic chapter, UUID comicId, Integer chapterNumber) {
        List<ChapterImage> images = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            try {
                String folderName = comicId + "_chapter_" + chapterNumber;
                String filePath = saveFile(files[i], folderName);
                ChapterImage img = new ChapterImage();
                img.setImageUrl(filePath);
                img.setPageNumber(i + 1);
                img.setChapterComic(chapter);
                images.add(img);
            } catch (IOException e) {
                throw new RuntimeException("Lỗi lưu file: " + files[i].getOriginalFilename(), e);
            }
        }
        return images;
    }
}
