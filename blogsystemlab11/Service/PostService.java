package com.example.blogsystemlab11.Service;

import com.example.blogsystemlab11.ApiResponse.ApiException;
import com.example.blogsystemlab11.Model.Post;
import com.example.blogsystemlab11.Repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;
    private final CategoryService categoryService;

    public PostService(PostRepository postRepository, UserService userService, CategoryService categoryService) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.categoryService = categoryService;
    }


    public List<Post> getAllPost() {
        return postRepository.findAll();
    }


    public Post getPost(Integer id) {
        return postRepository.findPostById(id);
    }
    public PostpostsByUserIdAndTitle(Integer id,String t) {
        return postRepository.findPostsByUserIdAndTitle(id,t);
    }


    public void addPost(Post post) {
        if (userService.getUser(post.getUserId()) != null) {
            if (categoryService.getCategoryById(post.getCategoryId()) != null) {
                postRepository.save(post);
            }
            throw new ApiException("category not found");
        }
        throw new ApiException("user not found");

    }

    public List<Post> getAllPostsBeforeDate(LocalDate date) {
        return postRepository.findAllPostsBeforeDate(date);
    }


    public Post getPostByTitle(String title) {
        return postRepository.findPostByTitle(title);
    }

    public void updatePost(Integer id, Post post) {
        Post check = postRepository.findPostById(id);
        if (check != null) {
            if (userService.getUser(post.getUserId()) != null) {
                if (categoryService.getCategoryById(post.getCategoryId()) != null) {
                    check.setContent(post.getContent());
                    check.setTitle(post.getTitle());
                    check.setCategoryId(post.getCategoryId());
                    postRepository.save(check);
                }
                throw new ApiException("category not found");
            }
            throw new ApiException("user not found");
        }
        throw new ApiException("post not found");
    }

    public List<Post> getAllPostsByUserId(Integer userId) {
        return postRepository.findAllPostsByUserId(userId);
    }

    public void deletePost(Integer id) {
        if (postRepository.findPostById(id) != null) {
            postRepository.delete(postRepository.findPostById(id));
        }
        throw new ApiException("User not found");
    }

}
