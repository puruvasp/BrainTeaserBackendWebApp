package com.BrainTeaser.service.impl;

import com.BrainTeaser.dto.ApplicationUserDto;
import com.BrainTeaser.model.ApplicationUser;
import com.BrainTeaser.repository.ApplicationUserRepository;
import com.BrainTeaser.service.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private final ApplicationUserRepository applicationUserRepository;

    private ApplicationUserDto mapToDto(ApplicationUser user) {
        return new ApplicationUserDto(
                user.getApplicationUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getStatus(),
                user.getLastLogin(),
                user.getLastLoginIP()
        );
    }

    private ApplicationUser mapToEntity(ApplicationUserDto dto) {
        ApplicationUser user = new ApplicationUser();
        user.setApplicationUserId(dto.getApplicationUserId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setStatus(dto.getStatus());
        user.setLastLogin(dto.getLastLogin());
        user.setLastLoginIP(dto.getLastLoginIP());

        return user;
    }

    @Override
    public ApplicationUserDto createUser(ApplicationUserDto userDto) {
        ApplicationUser user = mapToEntity(userDto);
        ApplicationUser saved = applicationUserRepository.save(user);
        return mapToDto(saved);
    }

    @Override
    public ApplicationUserDto getUserById(Long id) {
        ApplicationUser user = applicationUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        return mapToDto(user);
    }

    @Override
    public ApplicationUserDto getUserByUsername(String username) {
        ApplicationUser user = applicationUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username " + username));
        return mapToDto(user);
    }

    @Override
    public List<ApplicationUserDto> getAllUsers() {
        return applicationUserRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationUserDto updateUser(String username, ApplicationUserDto userDto) {
        ApplicationUser existing = applicationUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with id " + username));

        existing.setUsername(userDto.getUsername());
        existing.setEmail(userDto.getEmail());
        existing.setPassword(userDto.getPassword());
        existing.setStatus(userDto.getStatus());
        existing.setLastLogin(userDto.getLastLogin());
        existing.setLastLoginIP(userDto.getLastLoginIP());
        ApplicationUser updated = applicationUserRepository.save(existing);
        return mapToDto(updated);
    }

    @Override
    public void deleteUser(Long id) {
        ApplicationUser user = applicationUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        applicationUserRepository.delete(user);
    }

    @Override
    public void deleteUserByUsername(String username) {
        ApplicationUser user = applicationUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username " + username));
        applicationUserRepository.delete(user);
    }
}
