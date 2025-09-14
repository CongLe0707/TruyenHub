package com.example.TruyenHub.model.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Column(name = "avatar_url", length = 255)
    private String avatarUrl;

    @OneToMany(mappedBy = "author")
    private List<Story> stories;
}
