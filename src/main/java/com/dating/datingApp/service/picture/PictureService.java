package com.dating.datingApp.service.picture;

import com.dating.datingApp.model.Picture;

import java.util.List;

public interface PictureService {

    Picture savePicture(Picture picture);

    Picture getPicture(int id);

    List<Picture> getAllUserPictures(int userId);

    void deletePicture(int id);

    void updateUserProfilePicture(int userId, String newProfilePicture);
}
