package com.gfa.foxbook.foxbook.services;

import com.gfa.foxbook.foxbook.models.nonusermodels.Post;
import com.gfa.foxbook.foxbook.repositories.PostRepository;
import com.gfa.foxbook.foxbook.services.interfaces.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    @Override
    public List<Post> findByUserName(String username) {
        return postRepository.findByUsername(username);
    }

    @Override
    public Post createPost(Post post) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Post p = new Post();
        p.setUsername(post.getUsername());
        p.setContent(post.getContent());
        p.setCreatedAt(currentDateTime);
        return postRepository.save(p);
    }

    @Override
    public void editPost(Long id, String content) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isPresent()) {
            Post existingPost = optionalPost.get();
            existingPost.setContent(content);

            postRepository.save(existingPost);
        } else {
            throw new IllegalArgumentException("Post not found");
        }
    }

    @Override
    public List<Post> findAllByOrderByTimestampDesc() {
        return postRepository.findAllByOrderByCreatedAtDesc();
    }
}

