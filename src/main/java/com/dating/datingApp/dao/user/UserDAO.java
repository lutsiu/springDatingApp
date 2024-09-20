package com.dating.datingApp.dao.user;

import com.dating.datingApp.model.Interest;
import com.dating.datingApp.model.User;

public interface UserDAO {

    User createUser(User user);

    User getUser(int id);

    User updateUser(User user);

    void updateUserProfilePicture(int userId, String newProfilePicture);

    void updateUserPassword(int userId, String newPassword);

    void deleteUser(User user);


    // userInterest

    void addInterestToUser(int userId, Interest interest);
}
