package com.example.user.model.mapper;

import com.example.user.model.dto.UserProfileDto;
import com.example.user.model.entity.UserProfile;
import org.hibernate.sql.ast.tree.expression.Over;
import org.modelmapper.ModelMapper;

import com.example.user.model.dto.UserDto;
import com.example.user.model.entity.User;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

public class UserMapper extends BaseMapper<User, UserDto> {
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public User convertToEntity(UserDto dto, Object... args) {
        if (Objects.isNull(dto)) {
            return null;
        }

        User user = new User();
        BeanUtils.copyProperties(dto, user);

        // Handle nested UserProfile conversion
        if (Objects.nonNull(dto.getUserProfileDto())) {
            UserProfile userProfile = new UserProfile();
            BeanUtils.copyProperties(dto.getUserProfileDto(), userProfile);
            user.setUserProfile(userProfile);
        }

        return user;
    }

    @Override
    public UserDto convertToDto(User entity, Object... args) {
        if (Objects.isNull(entity)) {
            return null;
        }

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(entity, userDto);

        // Handle nested UserProfile conversion
        if (Objects.nonNull(entity.getUserProfile())) {
            UserProfileDto userProfileDto = new UserProfileDto();
            BeanUtils.copyProperties(entity.getUserProfile(), userProfileDto);
            userDto.setUserProfileDto(userProfileDto);
        }

        return userDto;
    }
}
