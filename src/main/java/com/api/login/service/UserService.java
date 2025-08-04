package com.api.login.service;

import com.api.login.dto.request.UserRequestDTO;
import com.api.login.dto.response.UserResponseDTO;
import com.api.login.exception.UserNotFoundException;
import com.api.login.model.User;
import com.api.login.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository repository;

    private UserResponseDTO mapperToDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO userDto) {
        User us = new User();
        BeanUtils.copyProperties(userDto,us);
        this.repository.save(us);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        BeanUtils.copyProperties(us, userResponseDTO);
        return userResponseDTO;
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userDto) {
        User user = this.repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id.toString()));

        BeanUtils.copyProperties(userDto, user);
        this.repository.save(user);
        return this.mapperToDTO(user);
    }
}
