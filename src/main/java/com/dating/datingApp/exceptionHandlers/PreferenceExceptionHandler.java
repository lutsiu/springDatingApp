package com.dating.datingApp.exceptionHandlers;

import com.dating.datingApp.exceptions.match.MatchNotFoundException;
import com.dating.datingApp.exceptions.preference.PreferenceNotFoundException;
import com.dating.datingApp.helpers.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)

public class PreferenceExceptionHandler {

    @ExceptionHandler(PreferenceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePreferenceNotFoundException(PreferenceNotFoundException exc) {
        ErrorResponse response = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Preference wasn't found",
                exc.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}