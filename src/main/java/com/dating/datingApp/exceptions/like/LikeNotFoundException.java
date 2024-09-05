package com.dating.datingApp.exceptions.like;

public class LikeNotFoundException extends RuntimeException {

    public LikeNotFoundException(int id) {
        super("Like with id " + id + " wasn't found");
    }
}
