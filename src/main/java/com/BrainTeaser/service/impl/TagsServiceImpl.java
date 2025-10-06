package com.BrainTeaser.service.impl;

import com.BrainTeaser.dto.TagsDto;
import com.BrainTeaser.model.Tags;
import com.BrainTeaser.repository.TagsRepository;
import com.BrainTeaser.service.TagsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagsServiceImpl implements TagsService {

    private final TagsRepository tagsRepository;

    private TagsDto mapToDto(Tags tag) {
        return new TagsDto(
                tag.getTagId(),
                tag.getTagName()
        );
    }

    private Tags mapToEntity(TagsDto dto) {
        Tags tag = new Tags();
        tag.setTagId(dto.getTagId());
        tag.setTagName(dto.getTagName());
        return tag;
    }

    @Override
    public TagsDto createTag(TagsDto tagsDto) {
        Tags tag = mapToEntity(tagsDto);
        Tags saved = tagsRepository.save(tag);
        return mapToDto(saved);
    }

    @Override
    public TagsDto getTagById(Long id) {
        Tags tag = tagsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag not found with id " + id));
        return mapToDto(tag);
    }

    @Override
    public TagsDto getTagByName(String tagName) {
        Tags tag = tagsRepository.findByTagName(tagName)
                .orElseThrow(() -> new RuntimeException("Tag not found with name " + tagName));
        return mapToDto(tag);
    }

    @Override
    public List<TagsDto> getAllTags() {
        return tagsRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TagsDto updateTag(Long id, TagsDto tagsDto) {
        Tags existing = tagsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag not found with id " + id));

        existing.setTagName(tagsDto.getTagName());
        Tags updated = tagsRepository.save(existing);
        return mapToDto(updated);
    }

    @Override
    public TagsDto updateTagByName(String tagName, TagsDto tagsDto) {
        Tags existing = tagsRepository.findByTagName(tagName)
                .orElseThrow(() -> new RuntimeException("Tag not found with name " + tagName));

        existing.setTagName(tagsDto.getTagName());
        Tags updated = tagsRepository.save(existing);
        return mapToDto(updated);
    }

    @Override
    public void deleteTag(Long id) {
        Tags tag = tagsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag not found with id " + id));
        tagsRepository.delete(tag);
    }

    @Override
    public void deleteTagByName(String tagName) {
        Tags tag = tagsRepository.findByTagName(tagName)
                .orElseThrow(() -> new RuntimeException("Tag not found with name " + tagName));
        tagsRepository.delete(tag);
    }
}
