package com.dating.datingApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "preference")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "min_age_range", nullable = false)
    private int minAgeRange;

    @Column(name = "max_age_range", nullable = false)
    private int maxAgeRange;

    @Column(name = "max_distance", nullable = false)
    private int maxDistance;


}
