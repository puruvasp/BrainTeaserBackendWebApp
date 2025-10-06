package com.BrainTeaser.service;

import com.BrainTeaser.dto.TagsDto;

import java.util.List;

public interface TagsService {

    TagsDto createTag(TagsDto tagsDto);

    TagsDto getTagById(Long id);

    TagsDto getTagByName(String tagName);

    List<TagsDto> getAllTags();

    TagsDto updateTag(Long id, TagsDto tagsDto);

    TagsDto updateTagByName(String tagName, TagsDto tagsDto);

    void deleteTag(Long id);

    void deleteTagByName(String tagName);
}
