package com.example.blogsystemlab11.Repository;

import com.example.blogsystemlab11.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    Post findPostById(Integer id);

    @Query("select post from Post post where post.categoryId=?1")
    List<Post>findPostsByCategoryId(Integer categoryId);

    @Query("SELECT p FROM Post p WHERE p.userId =?1")
    List<Post> findAllPostsByUserId(Integer userId);

    @Query("SELECT p FROM Post p WHERE p.title =?1")
    Post findPostByTitle(String title);

    @Query("SELECT p FROM Post p WHERE p.publishDate < ?1")
    List<Post> findAllPostsBeforeDate(LocalDate date);

    @Query("SELECT p FROM Post p WHERE p.userId = ?1 AND p.title = ?2")
    List<Post> findPostsByUserIdAndTitle(Integer userId, String title);



}
