package com.gfa.foxbook.foxbook.controllers;

import com.gfa.foxbook.foxbook.models.dtos.MessageDTO;
import com.gfa.foxbook.foxbook.models.dtos.UserProfileDTO;
import com.gfa.foxbook.foxbook.models.dtos.UserSearchDTO;
import com.gfa.foxbook.foxbook.models.nonusermodels.Post;
import com.gfa.foxbook.foxbook.models.User;
import com.gfa.foxbook.foxbook.services.ColorPersonalityServiceImpl;
import com.gfa.foxbook.foxbook.services.EmailServiceImpl;
import com.gfa.foxbook.foxbook.services.SpiritAnimalServiceImpl;
import com.gfa.foxbook.foxbook.services.interfaces.*;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/public")
@CrossOrigin(origins = {"http://localhost:4200", "http://foxhub.gfapp.eu", "https://foxhub.gfapp.eu"}, maxAge = 3600, allowCredentials = "true")
public class PublicController {
    private final UserService userService;
    private final PostService postService;
    private final PersonalityService personalityService;
    private final ColorPersonalityServiceImpl colorPersonalityService;
    private final LocationService locationService;
    private final EmailServiceImpl emailService;
    private final SpiritAnimalServiceImpl spiritAnimalService;
    private final LanguageService languageService;

    @GetMapping("/people")
    public ResponseEntity<?> getAllUsers() {
        try {
            List<User> users = userService.getAll();
            List<UserSearchDTO> usersDTO = new ArrayList<>();
            for (User user : users) {
                usersDTO.add(new UserSearchDTO(user));
            }
            if (users.isEmpty()) {
                System.out.println("No users found");
                return ResponseEntity.noContent().build();
            }
            System.out.println("Users found");
            return ResponseEntity.ok(usersDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/people/{nickname}")
    public ResponseEntity<?> personDetails(@PathVariable String nickname) {
        Optional<User> maybeUser = userService.findByNickname(nickname);
        if (maybeUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User user = maybeUser.get();
        UserProfileDTO userDTO = new UserProfileDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<?> getPostById(@PathVariable Long id) {
        Optional<Post> optionalPost = postService.findById(id);
        if (optionalPost.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Post post = optionalPost.get();
        return ResponseEntity.ok(post);
    }

    @GetMapping("/posts")
    public ResponseEntity<?> getAllPosts() {
        List<Post> posts = postService.findAllByOrderByTimestampDesc();
        if (posts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/people/search")
    public ResponseEntity<?> searchUsers(@RequestParam("query") String query) {
        List<User> users = userService.searchUsers(query);
        List<UserSearchDTO> usersDTO = new ArrayList<>();
        for (User user : users) {
            usersDTO.add(new UserSearchDTO(user));
        }
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usersDTO);
    }

    @GetMapping("/personalities")
    public ResponseEntity<?> getAllPersonalities() {
        return ResponseEntity.ok(personalityService.getAllPersonalities());
    }

    @GetMapping("/locations")
    public ResponseEntity<?> getAllLocations() {
        return ResponseEntity.ok(locationService.getAllLocations());
    }

    @GetMapping("/languages")
    public ResponseEntity<?> getAllLanguages() {
        return ResponseEntity.ok(languageService.getAllLanguages());
    }

    @GetMapping("/colorPersonalities")
    public ResponseEntity<?> getAllColorPersonalities() {
        return ResponseEntity.ok(colorPersonalityService.getAllColorPersonalities());
    }

    @GetMapping("/spiritAnimals")
    public ResponseEntity<?> getAllSpiritAnimals() {
        return ResponseEntity.ok(spiritAnimalService.getAllSpiritAnimals());
    }

    @GetMapping("/posts/comments/{id}")
    public ResponseEntity<?> getPostComments(@PathVariable Long id) {
        Optional<Post> optionalPost = postService.findById(id);
        if (optionalPost.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Post post = optionalPost.get();
        return ResponseEntity.ok(post.getComments());

    }

    @PostMapping("/contact")
    public ResponseEntity<?> contact(@RequestBody MessageDTO message) throws MessagingException {
        emailService.send("gfafoxbook@gmail.com", "Somebody is interested in students", "Person:\n" + message.message + "\nFrom email:" + message.from + "\nIs interested in these students:" + message.interestedIn);
        emailService.send(message.from, "Thanks for interest", "You have made interest in our students. We will contact you shortly with more information");
        return null;
    }
}
