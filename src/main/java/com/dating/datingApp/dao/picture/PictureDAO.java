package com.dating.datingApp.dao.picture;

import com.dating.datingApp.model.Picture;

import java.util.List;

public interface PictureDAO {

    Picture savePicture(Picture photo);

    Picture getPicture(int id);

    List<Picture> getAllUserPictures(int userId);

    void deletePicture(int id);

    void setAsProfilePicture(Picture picture);
}
