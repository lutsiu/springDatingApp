package com.dating.datingApp.dto.user;

import com.dating.datingApp.additionalFiles.Gender;
import com.dating.datingApp.model.Interest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    @Column(name = "id")
    private int id;

    @NotBlank(message = "{NotBlank.message}")
    private String firstName;

    @NotBlank(message = "{NotBlank.message}")
    private String lastName;

    @NotBlank(message = "{NotBlank.message}")
    @Email(message = "{Email.message}")
    private String email;

    @NotNull(message = "{NotNull.message}")
    private LocalDate dateOfBirth;

    @NotNull(message = "{NotNull.message}")
    private Gender gender;

    private String bio;

    private String profilePictureUrl;

}
