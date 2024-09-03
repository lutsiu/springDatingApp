package com.dating.datingApp.exceptionHandlers;


import com.dating.datingApp.exceptions.chat.ChatAlreadyExists;
import com.dating.datingApp.exceptions.chat.ChatNotFoundException;
import com.dating.datingApp.model.Chat;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.dating.datingApp.helpers.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ChatExceptionHandler {
    @ExceptionHandler(ChatAlreadyExists.class)
    public ResponseEntity<ErrorResponse> handleChatAlreadyExists(ChatAlreadyExists exc) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "Chat with these users already exists",
                exc.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(ChatNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleChatWasntFound(ChatNotFoundException exc) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Chat wasn't found",
                exc.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
