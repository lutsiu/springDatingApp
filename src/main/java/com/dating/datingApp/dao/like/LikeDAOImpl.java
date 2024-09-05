package com.dating.datingApp.dao.like;


import com.dating.datingApp.model.Like;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class LikeDAOImpl implements LikeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public Like saveLike(Like like) {
        entityManager.persist(like);
        return like;
    }

    @Override
    public Like getLike(int id) {
        return entityManager.find(Like.class, id);
    }

    @Override
    public Like getLikeByLikerAndLiked(int likerId, int likedId) {
        String query = "SELECT l FROM Like l WHERE l.likerId = :likerId AND l.likedId = :likedId";
        return entityManager.createQuery(query, Like.class)
                .setParameter("likerId", likerId)
                .setParameter("likedId", likedId)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Like> getAllLikesByUser(int likerId) {
        String query = "SELECT l FROM Like l WHERE l.likerId = :likerId";
        return entityManager.createQuery(query, Like.class)
                .setParameter("likerId", likerId)
                .getResultList();
    }

    @Override
    public boolean hasUserLiked(int likedId, int likerId) {
        String query = "SELECT COUNT(l) FROM Like l WHERE l.likedId = :likedId AND likerId = :likerId";
        Long count =  entityManager.createQuery(query, Long.class)
                .setParameter("likedId", likedId)
                .setParameter("likerId", likerId)
                .getSingleResult();
        return count > 0;
    }

    @Override
    @Transactional
    public void deleteLike(int id) {
        Like like = entityManager.find(Like.class, id);
        if (like != null) {
            System.out.println(id);
            entityManager.remove(like);
        }
    }
}
