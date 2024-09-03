package com.dating.datingApp.exceptions.message;

public class MessageNotFoundException extends RuntimeException{
    public MessageNotFoundException(int messageId) {
        super("Message with id " + messageId + " wasn't found");
    }

}
