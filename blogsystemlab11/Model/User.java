package com.example.blogsystemlab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "the user name cant be empty")
    @Size(min = 5,message = "user name cant be less than 5")
    @Column(columnDefinition = "varchar(25) not null unique")
    private String userName;

    @NotEmpty(message = "the user password cant be empty")

    @Column(columnDefinition = "varchar(25) not null ")
    private String password;

    @NotEmpty(message = "the user email cant be empty")
    @Email(message = "enter a valid email")
    @Column(columnDefinition = "varchar(25) not null unique")
    private String email;
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDate registrationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotEmpty(message = "the user name cant be empty") @Size(min = 5, message = "user name cant be less than 5") String getUserName() {
        return userName;
    }

    public void setUserName(@NotEmpty(message = "the user name cant be empty") @Size(min = 5, message = "user name cant be less than 5") String userName) {
        this.userName = userName;
    }

    public @NotEmpty(message = "the user password cant be empty") String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty(message = "the user password cant be empty") String password) {
        this.password = password;
    }

    public @NotEmpty(message = "the user email cant be empty") @Email(message = "enter a valid email") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "the user email cant be empty") @Email(message = "enter a valid email") String email) {
        this.email = email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
