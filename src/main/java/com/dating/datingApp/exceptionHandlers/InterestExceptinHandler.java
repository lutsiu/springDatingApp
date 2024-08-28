package com.dating.datingApp.exceptionHandlers;

import com.dating.datingApp.exceptions.interest.InterestNotFoundException;
import com.dating.datingApp.exceptions.user.UserNotFoundException;
import com.dating.datingApp.helpers.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)

public class InterestExceptinHandler {
    @ExceptionHandler(InterestNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(InterestNotFoundException exc) {
        System.out.println("InterestNotFoundException caught!");
        ErrorResponse response = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Interest wasn't found",
                exc.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
