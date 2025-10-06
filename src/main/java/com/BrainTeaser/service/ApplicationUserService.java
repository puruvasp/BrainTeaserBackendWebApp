package com.BrainTeaser.service;

import com.BrainTeaser.dto.ApplicationUserDto;
import java.util.List;

public interface ApplicationUserService {

    ApplicationUserDto createUser(ApplicationUserDto userDto);

    ApplicationUserDto getUserById(Long id);

    ApplicationUserDto getUserByUsername(String username);

    List<ApplicationUserDto> getAllUsers();

    ApplicationUserDto updateUser(String username, ApplicationUserDto userDto);

    void deleteUser(Long id);

    void deleteUserByUsername(String username);
}
