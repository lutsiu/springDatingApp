package com.dating.datingApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "interests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "interest_name", unique = true, nullable = false, length = 70)
    private String interestName;

    @ManyToMany(mappedBy = "interests")
    @JsonIgnore
    private Set<User> users;

    public void addUser(User user) {
        if (this.users == null) {
            this.users = new HashSet<>();
        }
        users.add(user);
    }

    @Override
    public String toString() {
        return "Interest{" +
                "id=" + id +
                ", interestName='" + interestName + '\'' +
                ", users=" + users +
                '}';
    }
}
