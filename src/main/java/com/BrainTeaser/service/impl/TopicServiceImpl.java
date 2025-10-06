package com.BrainTeaser.service.impl;

import com.BrainTeaser.dto.TopicDto;
import com.BrainTeaser.model.Topic;
import com.BrainTeaser.repository.TopicRepository;
import com.BrainTeaser.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    private TopicDto mapToDto(Topic topic) {
        return new TopicDto(
                topic.getTopicId(),
                topic.getTopicName()
        );
    }

    private Topic mapToEntity(TopicDto dto) {
        Topic topic = new Topic();
        topic.setTopicId(dto.getTopicId());
        topic.setTopicName(dto.getTopicName());
        return topic;
    }

    @Override
    public TopicDto createTopic(TopicDto topicDto) {
        Topic topic = mapToEntity(topicDto);
        Topic saved = topicRepository.save(topic);
        return mapToDto(saved);
    }

    @Override
    public TopicDto getTopicById(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found with id " + id));
        return mapToDto(topic);
    }

    @Override
    public TopicDto getTopicByName(String topicName) {
        Topic topic = topicRepository.findByTopicName(topicName)
                .orElseThrow(() -> new RuntimeException("Topic not found with name " + topicName));
        return mapToDto(topic);
    }

    @Override
    public List<TopicDto> getAllTopics() {
        return topicRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TopicDto updateTopic(Long id, TopicDto topicDto) {
        Topic existing = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found with id " + id));

        existing.setTopicName(topicDto.getTopicName());
        Topic updated = topicRepository.save(existing);
        return mapToDto(updated);
    }

    @Override
    public TopicDto updateTopicByName(String topicName, TopicDto topicDto) {
        Topic existing = topicRepository.findByTopicName(topicName)
                .orElseThrow(() -> new RuntimeException("Topic not found with name " + topicName));

        existing.setTopicName(topicDto.getTopicName());
        Topic updated = topicRepository.save(existing);
        return mapToDto(updated);
    }

    @Override
    public void deleteTopic(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found with id " + id));
        topicRepository.delete(topic);
    }

    @Override
    public void deleteTopicByName(String topicName) {
        Topic topic = topicRepository.findByTopicName(topicName)
                .orElseThrow(() -> new RuntimeException("Topic not found with name " + topicName));
        topicRepository.delete(topic);
    }
}
