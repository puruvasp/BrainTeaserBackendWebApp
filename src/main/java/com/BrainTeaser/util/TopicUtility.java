package com.BrainTeaser.util;

import org.mapstruct.Mapper;
import com.BrainTeaser.dto.TopicDto;
import com.BrainTeaser.model.Topic;

@Mapper(componentModel = "spring")
public interface TopicUtility {

    public abstract Topic toTopicEntity(TopicDto topicDto);
    public abstract TopicDto toTopicDto(Topic topic);
}
