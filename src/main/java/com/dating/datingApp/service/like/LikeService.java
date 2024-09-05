package com.dating.datingApp.service.like;

import com.dating.datingApp.model.Like;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    Optional<Like> saveLike(Like like);

    Like getLike(int id);

    List<Like> getAllLikesByUser(int likerId);

    void deleteLike(int id);
}
