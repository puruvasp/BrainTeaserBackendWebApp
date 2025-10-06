package com.BrainTeaser.util;

import com.BrainTeaser.dto.UserProfileDto;
import com.BrainTeaser.model.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileUtility {

    public abstract UserProfile toUserProfileEntity(UserProfileDto userProfileDto);
    public abstract UserProfileDto toUserProfileDto(UserProfile userProfile);

}
