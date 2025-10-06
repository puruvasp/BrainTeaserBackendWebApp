package com.BrainTeaser.repository;
import com.BrainTeaser.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Long> {
    Optional<Tags> findByTagName(String TagName);
}
