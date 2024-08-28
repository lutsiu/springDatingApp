package com.dating.datingApp.service.user;

import com.dating.datingApp.dto.user.UserCreateDTO;
import com.dating.datingApp.dto.user.UserDTO;
import com.dating.datingApp.dto.user.UserUpdateDTO;
import com.dating.datingApp.model.Interest;
import com.dating.datingApp.model.User;

public interface UserService {

    UserDTO createUser(UserCreateDTO userCreateDTO);

    UserDTO getUser(int id);

    UserDTO updateUser(int id, UserUpdateDTO userUpdateDTO);

    void updateUserPassword(int id, String newPassword);

    void updateUserProfilePicture(int id, String newUserProfilePicture);

    void deleteUser(int id);


    // userInterest
    void addInterestToUser(int userId, Interest interest);

}
