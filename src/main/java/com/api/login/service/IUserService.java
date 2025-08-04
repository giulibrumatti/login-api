package com.api.login.service;

import com.api.login.dto.request.UserRequestDTO;
import com.api.login.dto.response.UserResponseDTO;

public interface IUserService {

    public UserResponseDTO createUser(UserRequestDTO userDto);
    public UserResponseDTO updateUser(Long id, UserRequestDTO userDto);


}
