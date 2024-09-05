package com.dating.datingApp.exceptions.user;



public class UserNotFoundException extends RuntimeException {


    public UserNotFoundException(int id) {
        super("User with ID " + id + " wasn't found");
    }
    public UserNotFoundException(int id, String message) {
        super(message + " User with ID " + id + " wasn't found");
    }
}
