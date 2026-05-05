package com.studypair.Model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "study_groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class StudyGroup {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //module name
    @Column(nullable = false)
    private String subject;

    //5 people in a group
    @Column(nullable = false)
    private int maxSize  = 5;

    //current size of the group
    @OneToMany(mappedBy = "studyGroup", cascade = CascadeType.ALL)
    private List<User> members = new ArrayList<>();

    //check whether the group is full
    public boolean isFull() {
        return members.size() >= maxSize;
    }

    //add a member to the group
    public void addMember(User user){
        members.add(user);
        user.setStudyGroup(this);
    }
    
    //remove a member from the group
    public void removeMember(User user){
        members.remove(user);
        user.setStudyGroup(null);
    }
    
}
