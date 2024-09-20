package com.dating.datingApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "preferences")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = false)
    private int userId;


    @Min(value = 18, message = "Min age range must be greater or equal to 18")
    @Column(name = "min_age_range", nullable = false)
    private int minAgeRange;

    @Max(value = 60, message = "Max age range must be smaller or equal to 60")
    @Column(name = "max_age_range", nullable = false)
    private int maxAgeRange;

    @Max(value = 20, message = "Max distance must be smaller or equal to 20")
    @Column(name = "max_distance", nullable = false)
    private int maxDistance;


}
