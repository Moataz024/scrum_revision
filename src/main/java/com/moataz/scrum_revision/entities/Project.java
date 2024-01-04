package com.moataz.scrum_revision.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;

    @ManyToMany(mappedBy = "dev_projects")
    @ToString.Exclude
    private List<User> users;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "project")
    @ToString.Exclude
    private List<Sprint> sprints;
}