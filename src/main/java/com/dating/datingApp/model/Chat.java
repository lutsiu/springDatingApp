package com.dating.datingApp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "chats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id_1", nullable = false)
    private int userId1;

    @Column(name = "user_id_2", nullable = false)
    private int userId2;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", userId1=" + userId1 +
                ", userId2=" + userId2 +
                ", createdAt=" + createdAt +
                '}';
    }
}
