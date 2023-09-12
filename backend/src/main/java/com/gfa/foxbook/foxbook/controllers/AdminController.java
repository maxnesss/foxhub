package com.gfa.foxbook.foxbook.controllers;

import com.gfa.foxbook.foxbook.models.nonusermodels.Comment;
import com.gfa.foxbook.foxbook.models.nonusermodels.Post;
import com.gfa.foxbook.foxbook.models.User;
import com.gfa.foxbook.foxbook.models.dtos.PostDTO;
import com.gfa.foxbook.foxbook.repositories.CommentRepository;
import com.gfa.foxbook.foxbook.security.jwt.JwtUtils;
import com.gfa.foxbook.foxbook.services.interfaces.CommentService;
import com.gfa.foxbook.foxbook.services.interfaces.PostService;
import com.gfa.foxbook.foxbook.services.interfaces.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/admin")
@CrossOrigin(origins = {"http://localhost:4200", "http://foxhub.gfapp.eu", "https://foxhub.gfapp.eu"}, maxAge = 3600, allowCredentials = "true")
public class AdminController {
    public final PostService postService;
    private final JwtUtils jwtUtils;
    public final UserService userService;
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @PostMapping("/posts")
    public ResponseEntity<?> makePost(@RequestBody Post post, HttpServletRequest request) {
        User user = jwtUtils.getUserFromRequest(request);
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }
        post.setAuthorProfilePic(user.getProfilePictureUrl());
        return ResponseEntity.ok(postService.save(post));
    }

    @PatchMapping("/posts/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody PostDTO post) {
        Optional<Post> optionalPost = postService.findById(id);

        if (optionalPost.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        postService.editPost(optionalPost.get().getId(), post.getContent());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        Optional<Post> optionalPost = postService.findById(id);
        if (optionalPost.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Post post = optionalPost.get();
        postService.delete(post);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/change-role/{nickname}")
    public ResponseEntity<?> upgradeUser(@PathVariable String nickname) {
        Optional<User> maybeUser = userService.findByNickname(nickname);
        if (maybeUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User user = maybeUser.get();
        userService.changeRole(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/people/{nickname}")
    public ResponseEntity<?> deleteUser(@PathVariable String nickname) {
        Optional<User> maybeUser = userService.findByNickname(nickname);
        if (maybeUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User user = maybeUser.get();
        userService.delete(user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("post/{postId}/comment/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long postId, @PathVariable Long commentId, HttpServletRequest request) {
        Optional<Post> optionalPost = postService.findById(postId);
        if (optionalPost.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        if (optionalComment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Comment comment = optionalComment.get();
        commentService.deleteComment(comment);
        return ResponseEntity.noContent().build();
    }


}