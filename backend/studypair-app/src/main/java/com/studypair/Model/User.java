package com.studypair.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    
    @Column(nullable = false);
    private String password;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private boolean online;

    @ManyToMany
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;


}
