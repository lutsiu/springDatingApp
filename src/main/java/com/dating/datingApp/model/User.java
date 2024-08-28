package com.dating.datingApp.model;

import com.dating.datingApp.additionalFiles.Gender;
import com.dating.datingApp.additionalFiles.ValidationMessages;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name", nullable = false)
    @NotBlank(message = ValidationMessages.NOT_BLANK)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank(message = ValidationMessages.NOT_BLANK)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = ValidationMessages.NOT_BLANK)
    @Email(message = ValidationMessages.EMAIL)
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank(message = ValidationMessages.NOT_BLANK)
    private String password;

    @Column(name = "date_of_birth", nullable = false)
    @NotNull(message = ValidationMessages.NOT_NULL)
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    @NotNull(message = ValidationMessages.NOT_NULL)
    private Gender gender;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_interests",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id")
    )
    private Set<Interest> interests;

    public void addInterest(Interest interest) {
        if (this.interests == null) {
            this.interests = new HashSet<>();
        }

        interests.add(interest);
    }
}
