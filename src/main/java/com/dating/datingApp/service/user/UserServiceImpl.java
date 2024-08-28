package com.dating.datingApp.service.user;

import com.dating.datingApp.dao.user.UserDAO;
import com.dating.datingApp.dto.user.UserCreateDTO;
import com.dating.datingApp.dto.user.UserDTO;
import com.dating.datingApp.dto.user.UserUpdateDTO;
import com.dating.datingApp.exceptions.user.UserNotFoundException;
import com.dating.datingApp.helpers.UserConverter;
import com.dating.datingApp.model.Interest;
import com.dating.datingApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO dao;

    @Autowired
    private UserConverter converter;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        User user = converter.toUser(userCreateDTO);
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        dao.createUser(user);
        return converter.toUserDTO(user);
    }

    @Override
    public UserDTO getUser(int id) {
        User user = dao.getUser(id);
        if (user != null) {
            System.out.println(user.getInterests());
            return converter.toUserDTO(user);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public void updateUserPassword(int id, String newPassword) {
        User user = dao.getUser(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }
        String encryptedPasssword = encoder.encode(newPassword);

        dao.updateUserPassword(id, encryptedPasssword);
    }

    @Override
    public void updateUserProfilePicture(int id, String newUserProfilePicture) {
        User user = dao.getUser(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }
        dao.updateUserProfilePicture(id, newUserProfilePicture);
    }

    @Override
    public void deleteUser(int id) {
        User user = dao.getUser(id);
        if (user != null) {
            dao.deleteUser(user);
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public UserDTO updateUser(int id, UserUpdateDTO userUpdateDTO) {
        User existingUser = dao.getUser(id);

        if (existingUser ==null) {
            throw new UserNotFoundException(id);
        }

        existingUser.setFirstName(userUpdateDTO.getFirstName());
        existingUser.setLastName(userUpdateDTO.getLastName());
        existingUser.setEmail(userUpdateDTO.getEmail());
        existingUser.setBio(userUpdateDTO.getBio());
        existingUser.setProfilePictureUrl(userUpdateDTO.getProfilePictureUrl());

        dao.updateUser(existingUser);

        return converter.toUserDTO(existingUser);
    }

    @Override
    public void addInterestToUser(int userId, Interest interest) {
        User user = dao.getUser(userId);

        if (user == null) {
            throw new UserNotFoundException(userId);
        }

        if (user.getInterests().size() > 5) {
            throw new RuntimeException("User cannot have more than 5 interests");
        }
        dao.addInterestToUser(userId, interest);
    }
}
