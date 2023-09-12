package com.gfa.foxbook.foxbook.services.interfaces;

import com.gfa.foxbook.foxbook.models.nonusermodels.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> getAll();

    Optional<Post> findById(Long id);

    Post save(Post post);

    void delete(Post post);

    List<Post> findByUserName(String username);

    Post createPost(Post post);

    void editPost(Long id, String content);

//    Optional<Post> findById(Long id);
//
//    public Post save(Post post);
//
//    public void delete(Post post);
//
//    public List<Post> findAll();
//
    public List<Post> findAllByOrderByTimestampDesc();
//
//    public List<Post> findAllByOrderByTimestampAsc();
//
//    public List<Post> findAllByOrderByLikesDesc();
//
//    public List<Post> findByUserName(String authorName);
//
//    void remove(Post post);
//
//    Post createPost(String author, String title, String content);
//
//    Post editPost(Long id, String title, String content);
//
//    Post editPost(Post post);
//
//    void addComment(Comment newComment);
}
