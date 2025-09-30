package com.example.TruyenHub.infras.repo;

import com.example.TruyenHub.model.entity.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComicRepository extends JpaRepository<Comic, UUID> {

}
