package com.example.DeveloperProjeect.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "users_meeting",
            joinColumns = @JoinColumn(name = "usersId"),
            inverseJoinColumns = @JoinColumn(name = "meetingId"))
    Set<Meeting> usersMeeting;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "users-meeting",
//            joinColumns = {@JoinColumn(name = "usersId")},
//            inverseJoinColumns = {@JoinColumn(name = "meetingId")})
//    private Set<Meeting> meetings = new HashSet<>();
}
