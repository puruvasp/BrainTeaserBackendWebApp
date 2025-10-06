package com.BrainTeaser.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.BrainTeaser.model.Category;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCategoryName(String CategoryName);
}
