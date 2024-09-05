package com.dating.datingApp.service.like;

import com.dating.datingApp.dao.like.LikeDAO;
import com.dating.datingApp.dao.user.UserDAO;
import com.dating.datingApp.exceptions.like.LikeNotFoundException;
import com.dating.datingApp.exceptions.user.UserNotFoundException;
import com.dating.datingApp.model.Like;
import com.dating.datingApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeDAO dao;

    @Autowired
    private UserDAO userDAO;

    @Override
    public Optional<Like> saveLike(Like like) {

        // check if one of users doesn't exist
        User likedUser = userDAO.getUser(like.getLikedId());
        User likerUser = userDAO.getUser(like.getLikerId());
        if (likedUser == null) {
            throw new UserNotFoundException(like.getLikedId(), "Liked");
        }
        if (likerUser == null) {
            throw new UserNotFoundException(like.getLikerId(), "Liker");
        }

        // check if user had already been liked

        boolean hasAlreadyLiked = dao.hasUserLiked(like.getLikedId(), like.getLikerId());

        if (hasAlreadyLiked) {

            Like existingLike = dao.getLikeByLikerAndLiked(like.getLikerId(), like.getLikedId());
            System.out.println(existingLike);
            dao.deleteLike(existingLike.getId());
            return Optional.empty();
        }

        return Optional.of(dao.saveLike(like));
    }

    @Override
    public Like getLike(int id) {
        Like like = dao.getLike(id);
        if (like == null) {
            throw new LikeNotFoundException(id);
        }
        return like;
    }

    @Override
    public List<Like> getAllLikesByUser(int likerId) {
        User user = userDAO.getUser(likerId);
        if (user == null) {
            throw new UserNotFoundException(likerId);
        }
        return dao.getAllLikesByUser(likerId);
    }

    @Override
    public void deleteLike(int id) {
        Like like = dao.getLike(id);
        if (like == null) {
            throw new LikeNotFoundException(id);
        }
        dao.deleteLike(id);
    }
}
