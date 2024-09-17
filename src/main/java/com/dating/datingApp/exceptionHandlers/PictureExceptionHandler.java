package com.dating.datingApp.exceptionHandlers;

import com.dating.datingApp.exceptions.picture.PictureNorFoundException;
import com.dating.datingApp.helpers.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PictureExceptionHandler {

    @ExceptionHandler(PictureNorFoundException.class)
    private ResponseEntity<ErrorResponse> handlePictureNotFound(PictureNorFoundException exc) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "The picture wasn't found",
                exc.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


}
