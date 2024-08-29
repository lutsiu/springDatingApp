package com.dating.datingApp.exceptions.chat;

public class ChatAlreadyExists extends RuntimeException {
    public ChatAlreadyExists(int userId1, int userId2) {
        super("Chat with these two users already exists: userId1 : " +
                userId1 + " userId2 : " + userId2 );
    }
}
