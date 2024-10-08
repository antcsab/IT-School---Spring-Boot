package com.itschool.project.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.project.models.dtos.UserDTO;
import com.itschool.project.models.entities.User;
import com.itschool.project.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if (userDTO.getEmail().length() < 3) {
            throw new RuntimeException("Invalid email!");
        }

        User userEntityToBeSaved = objectMapper.convertValue(userDTO, User.class);
        User userResponseEntity = userRepository.save(userEntityToBeSaved);
        log.info("Created user with id: {}", userResponseEntity.getId());

        return objectMapper.convertValue(userResponseEntity, UserDTO.class);
    }

    public UserServiceImpl(UserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> objectMapper.convertValue(user, UserDTO.class))
                .toList();
    }
}
