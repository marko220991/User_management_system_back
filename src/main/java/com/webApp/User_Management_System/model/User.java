package com.webApp.User_Management_System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "email")
    @Email(message = "This value needs to have structure as email with @ sign in it!")
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
