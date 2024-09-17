package com.dating.datingApp.service.picture;

import com.dating.datingApp.dao.picture.PictureDAO;
import com.dating.datingApp.dao.user.UserDAO;
import com.dating.datingApp.exceptions.picture.PictureNorFoundException;
import com.dating.datingApp.exceptions.user.UserNotFoundException;
import com.dating.datingApp.model.Picture;
import com.dating.datingApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDAO dao;

    @Autowired
    private UserDAO userDAO;

    @Override
    public Picture savePicture(Picture picture) {
        return dao.savePicture(picture);
    }

    @Override
    public Picture getPicture(int id) {
        Picture picture = dao.getPicture(id);
        if (picture == null) {
            throw new PictureNorFoundException(id);
        }
        return picture;
    }

    @Override
    public List<Picture> getAllUserPictures(int userId) {
        User user = userDAO.getUser(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        return dao.getAllUserPictures(userId);
    }

    @Override
    public void deletePicture(int id) {
        Picture picture = dao.getPicture(id);
        if (picture == null) {
            throw new PictureNorFoundException(id);
        }
        dao.deletePicture(id);
    }

    @Override
    public void setAsProfilePicture(Picture picture) {
        dao.setAsProfilePicture(picture);
    }
}
