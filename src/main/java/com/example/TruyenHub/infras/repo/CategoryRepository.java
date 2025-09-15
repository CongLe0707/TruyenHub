package com.example.TruyenHub.infras.repo;

import com.example.TruyenHub.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
public interface CategoryRepository extends JpaRepository<Category, UUID> {

}