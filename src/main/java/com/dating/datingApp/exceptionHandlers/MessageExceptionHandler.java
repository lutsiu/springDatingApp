package com.dating.datingApp.exceptionHandlers;

import com.dating.datingApp.exceptions.message.MessageNotFoundException;
import com.dating.datingApp.exceptions.message.MessageTextIsEmptyException;
import com.dating.datingApp.exceptions.message.MessageWasMarkedAsRead;
import com.dating.datingApp.helpers.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MessageExceptionHandler {

    @ExceptionHandler(MessageTextIsEmptyException.class)
    public ResponseEntity<ErrorResponse> messageIsEmpty(MessageTextIsEmptyException exc) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Please, provide text to the message",
                exc.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MessageNotFoundException.class)
    public ResponseEntity<ErrorResponse> messageIsNotFound(MessageNotFoundException exc) {
        ErrorResponse response = new ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            "The message wasn't found",
            exc.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MessageWasMarkedAsRead.class)
    public ResponseEntity<ErrorResponse> messageWasMarkedAsRead(MessageWasMarkedAsRead exc) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "Message was read",
                exc.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
