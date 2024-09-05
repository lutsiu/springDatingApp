package com.dating.datingApp.dao.like;


import com.dating.datingApp.model.Like;

import java.util.List;

public interface LikeDAO {

    Like saveLike(Like like);

    Like getLike(int id);

    Like getLikeByLikerAndLiked(int likerId, int likedId);

    List<Like> getAllLikesByUser(int likerId);

    void deleteLike(int id);


    boolean hasUserLiked(int likedId, int likerId);


}
