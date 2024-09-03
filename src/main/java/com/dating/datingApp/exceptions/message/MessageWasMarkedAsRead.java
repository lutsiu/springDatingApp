package com.dating.datingApp.exceptions.message;

public class MessageWasMarkedAsRead extends RuntimeException{
    public MessageWasMarkedAsRead(int messageId) {
        super("Message with id " + messageId + " have been already read");
    }
}
