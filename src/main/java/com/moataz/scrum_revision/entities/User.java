package com.moataz.scrum_revision.entities;

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
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String fName;
    private String lName;
    private String pwd;
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany()
    @ToString.Exclude
    private List<Project> dev_projects;

    @OneToMany
    @ToString.Exclude
    private List<Project> sm_projects;


}
