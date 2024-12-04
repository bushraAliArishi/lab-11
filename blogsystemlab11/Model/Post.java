package com.example.blogsystemlab11.Model;

import jakarta.persistence.*;
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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "category id cant be empty")
    @Column(columnDefinition = "int not null")
    private Integer categoryId;

    @NotEmpty(message = "post title cant be empty")
    @Size(min = 6,max = 30,message = "the title cant be less than 6 and more than 30")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String title;

    @NotEmpty(message = "post content cant be empty")
    @Size(min = 150,max = 255,message = "the title cant be less than 150 and more than 255")
    @Column(columnDefinition = "varchar(255) not null unique")
    private String content;

    @NotNull(message = "creator id cant be empty")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @NotNull(message = "publish Date cant be empty")
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDate publishDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "category id cant be empty") Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(@NotNull(message = "category id cant be empty") Integer categoryId) {
        this.categoryId = categoryId;
    }

    public @NotEmpty(message = "post title cant be empty") @Size(min = 6, max = 30, message = "the title cant be less than 6 and more than 30") String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty(message = "post title cant be empty") @Size(min = 6, max = 30, message = "the title cant be less than 6 and more than 30") String title) {
        this.title = title;
    }

    public @NotEmpty(message = "post content cant be empty") @Size(min = 150, max = 255, message = "the title cant be less than 150 and more than 255") String getContent() {
        return content;
    }

    public void setContent(@NotEmpty(message = "post content cant be empty") @Size(min = 150, max = 255, message = "the title cant be less than 150 and more than 255") String content) {
        this.content = content;
    }

    public @NotNull(message = "creator id cant be empty") Integer getUserId() {
        return userId;
    }

    public void setUserId(@NotNull(message = "creator id cant be empty") Integer userId) {
        this.userId = userId;
    }

    public @NotNull(message = "publish Date cant be empty") LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(@NotNull(message = "publish Date cant be empty") LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}
