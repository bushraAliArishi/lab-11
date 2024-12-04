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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "category id cant be empty")
    @Column(columnDefinition = "int not null")
    private Integer postId;

    @NotNull(message = "creator id cant be empty")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @NotEmpty(message = "Comment content cant be empty")
    @Size(min = 20,max = 255,message = "the title cant be less than 20 and more than 255")
    @Column(columnDefinition = "varchar(255) not null ")
    private String content;

    @NotNull(message = "Comment Date cant be empty")
    @Column(columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDate commentDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "category id cant be empty") Integer getPostId() {
        return postId;
    }

    public void setPostId(@NotNull(message = "category id cant be empty") Integer postId) {
        this.postId = postId;
    }

    public @NotNull(message = "creator id cant be empty") Integer getUserId() {
        return userId;
    }

    public void setUserId(@NotNull(message = "creator id cant be empty") Integer userId) {
        this.userId = userId;
    }

    public @NotEmpty(message = "Comment content cant be empty") @Size(min = 20, max = 255, message = "the title cant be less than 20 and more than 255") String getContent() {
        return content;
    }

    public void setContent(@NotEmpty(message = "Comment content cant be empty") @Size(min = 20, max = 255, message = "the title cant be less than 20 and more than 255") String content) {
        this.content = content;
    }

    public @NotNull(message = "Comment Date cant be empty") LocalDate getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(@NotNull(message = "Comment Date cant be empty") LocalDate commentDate) {
        this.commentDate = commentDate;
    }
}
