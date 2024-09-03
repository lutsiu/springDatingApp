package com.dating.datingApp.exceptions.chat;

public class ChatNotFoundException extends RuntimeException{
    public ChatNotFoundException(int chatId) {
        super("Chat with id " + chatId + " wasn't found");
    }
}
