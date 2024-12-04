package com.example.blogsystemlab11.Controller;

import com.example.blogsystemlab11.Model.Post;
import com.example.blogsystemlab11.Service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/display")
    public ResponseEntity getAllPost() {
        return ResponseEntity.status(200).body(postService.getAllPost());
    }

    @PostMapping("/add")
    public ResponseEntity addPost(@RequestBody @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        postService.addPost(post);
        return ResponseEntity.status(200).body("Post has been added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id, @RequestBody @Valid Post post, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        postService.updatePost(id, post);
        return ResponseEntity.status(200).body("Post has been updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.status(200).body("Post has been deleted");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity getPostsByUserId(@PathVariable Integer userId) {
        List<Post> posts = postService.getAllPostsByUserId(userId);
        return ResponseEntity.status(200).body(posts);
    }
    @GetMapping("/user/{userId}/{title}")
    public ResponseEntity getPostsByUserId(@PathVariable Integer userId,@PathVariable String title) {
        List<Post> posts = postService.postsByUserIdAndTitle(userId,title);
        return ResponseEntity.status(200).body(posts);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity getPostByTitle(@PathVariable String title) {
        Post post = postService.getPostByTitle(title);
        if (post == null) {
            return ResponseEntity.status(404).body("Post not found");
        }
        return ResponseEntity.status(200).body(post);
    }

    @GetMapping("/beforeDate/{date}")
    public ResponseEntity getAllPostsBeforeDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        List<Post> posts = postService.getAllPostsBeforeDate(localDate);
        return ResponseEntity.status(200).body(posts);
    }
}
