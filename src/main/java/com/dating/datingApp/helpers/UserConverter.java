package com.dating.datingApp.helpers;

import com.dating.datingApp.dto.user.UserCreateDTO;
import com.dating.datingApp.dto.user.UserDTO;
import com.dating.datingApp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User toUser(UserCreateDTO userCreateDTO) {
        User user = new User();
        user.setFirstName(userCreateDTO.getFirstName());
        user.setLastName(userCreateDTO.getLastName());
        user.setEmail(userCreateDTO.getEmail());
        user.setDateOfBirth(userCreateDTO.getDateOfBirth());
        user.setGender(userCreateDTO.getGender());
        user.setBio(userCreateDTO.getBio());
        user.setProfilePictureUrl(userCreateDTO.getProfilePictureUrl());
        user.setPassword(userCreateDTO.getPassword());
        return user;
    }

    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setDateOfBirth(user.getDateOfBirth());
        userDTO.setGender(user.getGender());
        userDTO.setBio(user.getBio());
        userDTO.setProfilePictureUrl(user.getProfilePictureUrl());
        return userDTO;
    }
}
