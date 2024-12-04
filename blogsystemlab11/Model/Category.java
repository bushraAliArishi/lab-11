package com.example.blogsystemlab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "category name cant be empty")
    @Column(columnDefinition = "varchar(25) not null unique")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotEmpty(message = "category name cant be empty") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "category name cant be empty") String name) {
        this.name = name;
    }
}
