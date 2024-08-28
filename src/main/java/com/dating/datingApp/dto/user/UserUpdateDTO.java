package com.dating.datingApp.dto.user;

import com.dating.datingApp.additionalFiles.Gender;
import com.dating.datingApp.additionalFiles.ValidationMessages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUpdateDTO {

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    private String firstName;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    private String lastName;

    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Email(message = ValidationMessages.EMAIL)
    private String email;

    private String bio;

    private String profilePictureUrl;


}
