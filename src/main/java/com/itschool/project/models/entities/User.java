package com.itschool.project.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

   // private String location;

    @Column(name = "email")
    private String email;
}
