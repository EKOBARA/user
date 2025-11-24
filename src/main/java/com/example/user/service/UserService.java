package com.example.user.service;

import com.example.user.model.dto.CreateUser;
import com.example.user.model.dto.UserDto;
import com.example.user.model.dto.UserUpdate;
import com.example.user.model.dto.UserUpdateStatus;
import com.example.user.model.dto.response.Response;

import java.util.List;

public interface UserService {

    Response createUser(CreateUser userDto);

    List<UserDto> readAllUsers();

    UserDto readUser(String authId);

    Response updateUserStatus(Long id, UserUpdateStatus userUpdate);

    Response updateUser(Long id, UserUpdate userUpdate);

    UserDto readUserById(Long userId);

    UserDto readUserByAccountId(String accountId);
}
