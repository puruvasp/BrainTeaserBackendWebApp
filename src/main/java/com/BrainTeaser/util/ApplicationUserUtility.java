package com.BrainTeaser.util;

import com.BrainTeaser.dto.ApplicationUserDto;
import com.BrainTeaser.model.ApplicationUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApplicationUserUtility {

    public abstract ApplicationUser toApplicationUserEntity(ApplicationUserDto applicationUserDto);
    public abstract ApplicationUserDto toApplicationUserDto(ApplicationUser applicationUser);

}
