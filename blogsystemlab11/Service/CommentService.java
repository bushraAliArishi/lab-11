package com.example.blogsystemlab11.Service;

import com.example.blogsystemlab11.ApiResponse.ApiException;
import com.example.blogsystemlab11.Model.Comment;
import com.example.blogsystemlab11.Repository.CommentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;
    private final UserService userService;

    public CommentService(CommentRepository commentRepository, PostService postService, UserService userService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
        this.userService = userService;
    }


    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    public void addComment(Comment comment) {
        if (userService.getUser(comment.getUserId()) != null) {
            if (postService.getPost(comment.getPostId()) != null) {
                comment.setCommentDate(comment.getCommentDate().now());
                commentRepository.save(comment);
            }
            throw new ApiException("post not found");
        }
        throw new ApiException("user not found");

    }


    public List<Comment> getAllCommentsByPostId(Integer postId) {
        return commentRepository.findAllCommentsByPostId(postId);
    }

    public void updateComment(Integer id, Comment comment) {

        if (userService.getUser(comment.getUserId()) != null) {
            if (postService.getPost(comment.getPostId()) != null) {
                Comment check = commentRepository.findCommentById(id);
                if (check != null) {
                    check.setContent(comment.getContent());
                    check.setPostId(comment.getPostId());
                    check.setUserId(comment.getUserId());
                    check.setCommentDate(comment.getCommentDate().now());
                    commentRepository.save(check);
                }
                throw new ApiException("comment not found");
            }
            throw new ApiException("post not found");
        }
        throw new ApiException("user not found");

    }

    public void deleteComment(Integer id) {
        if (commentRepository.findCommentById(id) != null) {
            commentRepository.delete(commentRepository.findCommentById(id));
        }
        throw new ApiException("comment not found");
    }
}
