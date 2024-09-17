package com.dating.datingApp.exceptions.picture;

public class PictureNorFoundException extends RuntimeException {

    public PictureNorFoundException(int id) {
        super("Picture with id " + id + " wasn't found");
    }
}
