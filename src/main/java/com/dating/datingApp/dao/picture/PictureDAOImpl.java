package com.dating.datingApp.dao.picture;

import com.dating.datingApp.model.Picture;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PictureDAOImpl implements PictureDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Picture savePicture(Picture photo) {
        entityManager.persist(photo);
        return photo;
    }

    @Override
    public Picture getPicture(int id) {
        return entityManager.find(Picture.class, id);
    }

    @Override
    public List<Picture> getAllUserPictures(int userId) {
        String query = "SELECT p FROM Picture p WHERE p.userId = :userId";
        return entityManager.createQuery(query, Picture.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public void deletePicture(int id) {
        Picture picture = entityManager.find(Picture.class, id);
        if (picture !=null) {
            entityManager.remove(picture);
        }
    }

    @Override
    public void setAsProfilePicture(Picture newProfilePicture) {
        String query = "UPDATE Picture p SET p.isProfilePicture = false WHERE" +
                " p.userId = :userId AND p.isProfilePicture = true";
        entityManager.createQuery(query, Picture.class)
                .setParameter("userId", newProfilePicture.getUserId())
                .executeUpdate();

        newProfilePicture.setProfilePhoto(true);
        entityManager.merge(newProfilePicture);
    }
}
