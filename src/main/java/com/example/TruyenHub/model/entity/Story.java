package com.example.TruyenHub.model.entity;

import com.example.TruyenHub.model.enums.StoryStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "stories")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "cover_image", length = 255)
    private String coverImage;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    private StoryStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;


}
