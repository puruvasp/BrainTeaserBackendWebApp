package com.BrainTeaser.util;

import org.mapstruct.Mapper;
import com.BrainTeaser.dto.TagsDto;
import com.BrainTeaser.model.Tags;

@Mapper(componentModel = "spring")
public interface TagsUtility {

    public abstract Tags toTagsEntity(TagsDto tagsDto);
    public abstract TagsDto toTagsDto(Tags tags);

}
