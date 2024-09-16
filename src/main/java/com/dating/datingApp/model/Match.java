package com.dating.datingApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "matches")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id_1", nullable = false)
    private int userId1;

    @Column(name = "user_id_2", nullable = false)
    private int userId2;

    @CreationTimestamp
    @Column(name = "matched_at", updatable = false)
    private LocalDateTime matchedAt;
}
