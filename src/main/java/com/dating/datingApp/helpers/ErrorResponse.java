package com.dating.datingApp.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {

    private int status;
    private String message;
    private String details;


}
