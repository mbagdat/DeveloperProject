package com.example.DeveloperProjeect.Entity;


import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "meeting")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "attendee")
    private String attendee;

    @ManyToMany(mappedBy = "usersMeeting")
    Set<User> users_meeting;
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "meetings")
//    private Set<User> users = new HashSet<>();

}
