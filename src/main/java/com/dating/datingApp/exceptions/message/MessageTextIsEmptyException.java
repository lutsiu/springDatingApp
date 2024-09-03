package com.dating.datingApp.exceptions.message;

public class MessageTextIsEmptyException extends RuntimeException{
    public MessageTextIsEmptyException() {
        super("Message is empty!!!");
    }
}
