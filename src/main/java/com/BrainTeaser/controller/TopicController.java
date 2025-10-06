package com.BrainTeaser.controller;

import com.BrainTeaser.dto.TopicDto;
import com.BrainTeaser.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/topics")
@RequiredArgsConstructor
@Tag(name = "Topic Controller", description = "Endpoints for managing topics")
public class TopicController {

    private final TopicService topicService;

    @Operation(summary = "Create a new topic")
    @PostMapping("/create")
    public ResponseEntity<TopicDto> createTopic(@RequestBody TopicDto topicDto) {
        TopicDto createdTopic = topicService.createTopic(topicDto);
        return ResponseEntity.ok(createdTopic);
    }

    @Operation(summary = "Get topic by ID")
    @GetMapping("/{id}")
    public ResponseEntity<TopicDto> getTopicById(@PathVariable Long id) {
        TopicDto topic = topicService.getTopicById(id);
        return ResponseEntity.ok(topic);
    }

    @Operation(summary = "Get topic by name")
    @GetMapping("/{topicName}")
    public ResponseEntity<TopicDto> getTopicByName(@PathVariable String topicName) {
        TopicDto topic = topicService.getTopicByName(topicName);
        return ResponseEntity.ok(topic);
    }

    @Operation(summary = "Get all topics")
    @GetMapping("/all")
    public ResponseEntity<List<TopicDto>> getAllTopics() {
        List<TopicDto> topics = topicService.getAllTopics();
        return ResponseEntity.ok(topics);
    }

    @Operation(summary = "Update topic by ID")
    @PutMapping("/{id}")
    public ResponseEntity<TopicDto> updateTopic(@PathVariable Long id, @RequestBody TopicDto topicDto) {
        TopicDto updatedTopic = topicService.updateTopic(id, topicDto);
        return ResponseEntity.ok(updatedTopic);
    }

    @PutMapping("/{topicName}")
    public ResponseEntity<TopicDto> updateTopicByName(@PathVariable String topicName, @RequestBody TopicDto topicDto) {
        TopicDto updatedTopic = topicService.updateTopicByName(topicName, topicDto);
        return ResponseEntity.ok(updatedTopic);
    }

    @Operation(summary = "Delete topic by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.ok("Topic deleted successfully with ID: " + id);
    }

    @Operation(summary = "Delete topic by name")
    @DeleteMapping("/{topicName}")
    public ResponseEntity<String> deleteTopicByName(@PathVariable String topicName) {
        topicService.deleteTopicByName(topicName);
        return ResponseEntity.ok("Topic deleted successfully with name: " + topicName);
    }
}
