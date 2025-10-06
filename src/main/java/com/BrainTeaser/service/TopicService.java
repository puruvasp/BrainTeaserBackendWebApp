package com.BrainTeaser.service;

import com.BrainTeaser.dto.TopicDto;

import java.util.List;

public interface TopicService {

    TopicDto createTopic(TopicDto topicDto);

    TopicDto getTopicById(Long id);

    TopicDto getTopicByName(String topicName);

    List<TopicDto> getAllTopics();

    TopicDto updateTopic(Long id, TopicDto topicDto);

    TopicDto updateTopicByName(String topicName, TopicDto topicDto);

    void deleteTopic(Long id);

    void deleteTopicByName(String topicName);
}
