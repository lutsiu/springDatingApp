package com.dating.datingApp.dao.user;

import com.dating.datingApp.model.Interest;
import com.dating.datingApp.model.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User getUser(int id) {
        User user = entityManager.find(User.class, id);

        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    @Override
    @Transactional
    public void updateUserPassword(int userId, String newPassword) {
        User user = getUser(userId);
        if (user != null) {
            user.setPassword(newPassword);
            entityManager.merge(user);
        }
    }

    @Override
    @Transactional
    public void updateUserProfilePicture(int userId, String newProfilePicture) {
        User user = getUser(userId);
        if (user !=null) {
            user.setProfilePictureUrl(newProfilePicture);
            entityManager.merge(user);
        }
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    // userInterest


    @Override
    @Transactional
    public void addInterestToUser(int userId, Interest interest) {
        User user = getUser(userId);

        if (user == null) return;
        user.addInterest(interest);
        Set<Interest> interests = user.getInterests();
        interests.add(interest);
        user.setInterests(interests);
        entityManager.merge(user);
    }
}
