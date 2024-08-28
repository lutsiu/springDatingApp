package com.dating.datingApp.dto.user;

import com.dating.datingApp.additionalFiles.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCreateDTO {

    @NotBlank(message = "{NotBlank.message}")
    private String firstName;

    @NotBlank(message = "{NotBlank.message}")
    private String lastName;

    @NotBlank(message = "{NotBlank.message}")

    @Email(message = "{Email.message}")
    private String email;

    @NotBlank(message = "{NotBlank.message}")
    private String password;

    @NotNull(message = "{NotNull.message}")
    private LocalDate dateOfBirth;

    @NotNull(message = "{NotNull.message}")
    private Gender gender;

    private String bio;

    private String profilePictureUrl;



}
