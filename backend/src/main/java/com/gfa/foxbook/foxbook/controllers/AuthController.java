package com.gfa.foxbook.foxbook.controllers;

import com.gfa.foxbook.foxbook.models.User;
import com.gfa.foxbook.foxbook.models.dtos.EmailDTO;
import com.gfa.foxbook.foxbook.models.dtos.security.LoginDto;
import com.gfa.foxbook.foxbook.models.dtos.security.LoginResponseDto;
import com.gfa.foxbook.foxbook.models.dtos.security.RegisterDto;
import com.gfa.foxbook.foxbook.security.jwt.JwtUtils;
import com.gfa.foxbook.foxbook.security.services.SecurityService;
import com.gfa.foxbook.foxbook.services.EmailServiceImpl;
import com.gfa.foxbook.foxbook.services.interfaces.UserService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "http://foxhub.gfapp.eu", "https://foxhub.gfapp.eu"}, maxAge = 3600, allowCredentials = "true")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final SecurityService securityService;
    private final UserService userService;
    private final EmailServiceImpl emailService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            ResponseCookie jwtRefreshCookie = jwtUtils.generateRefreshJwtCookie(authentication);
            ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(authentication);
            if (!(userService.findByEmail(authentication.getName()).get().isVerified())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You have to verify your email");
            }

            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                    .header(HttpHeaders.SET_COOKIE, jwtRefreshCookie.toString())
                    .body(new LoginResponseDto(userService.findByEmail(authentication.getName())
                            .orElseThrow(() -> new IllegalStateException("User not found"))
                            .getNickname()));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid login credentials");
        }
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto) throws MessagingException {
        if (securityService.userExistsByEmail(registerDto.getEmail())) {
            return ResponseEntity.badRequest().body("Email already registered");
        }
        securityService.registerUser(registerDto);
        emailService.send(registerDto.getEmail(), "Welcome to Foxhub", emailService.generateWelcomeEmail(registerDto.getFirstName()));
        emailService.send(registerDto.getEmail(), "Foxhub - Email verification", emailService.generateVerificationEmail(userService.findByEmail(registerDto.getEmail()).get().getVerificationToken()));

        return ResponseEntity.ok().build();
    }

    @PostMapping("signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie jwtCookie = jwtUtils.getCleanJwtCookie();
        ResponseCookie jwtRefreshCookie = jwtUtils.getCleanJwtRefreshCookie();
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .header(HttpHeaders.SET_COOKIE, jwtRefreshCookie.toString())
                .build();
    }

    @PostMapping("refresh")
    public ResponseEntity<?> refreshToken(HttpServletRequest request) {
        if (jwtUtils.getRefreshTokenValidateAndGenerateAccessToken(request) != null) {
            ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(jwtUtils.getRefreshTokenValidateAndGenerateAccessToken(request));

            return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString()).build();
        }
        return ResponseEntity.badRequest().body("Refresh token is expired");
    }

    @PostMapping("password-reset")
    public ResponseEntity<?> resetPassword(@RequestBody EmailDTO emailDTO) throws MessagingException {
        Optional<User> user = userService.findByEmailAndYearOfBirth(emailDTO.getEmail(), emailDTO.getYearOfBirth());
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().body("this user does not exist");
        }

        if (!(user.get().getEmail().equals(emailDTO.getEmail()) && user.get().getYearOfBirth() == emailDTO.getYearOfBirth())) {
            return ResponseEntity.badRequest().body("given user info is not valid");
        }

        String newPassword = UUID.randomUUID().toString();
        user.get().setPassword(passwordEncoder.encode(newPassword));

        userService.saveUser(user.get());

        String emailBody = "<!DOCTYPE html><html lang=\"en\">" +
                "<head><meta charset=\"UTF-8\"><meta name=\"viewport\" " +
                "content=\"width=device-width,initial-scale=1.0\">" +
                "<title>FoxHub - Password Reset</title></head>" +
                "<body><div style=\"max-width:600px;margin:0 " +
                "auto;padding:20px;background-color:#ffffff;" +
                "box-shadow:0px 0px 10px 0px rgba(0,0,0,0.1);\">" +
                "<h1 style=\"color:#4CAF50;text-align:left;\">" +
                "FoxHub - Password Reset</h1><h3 style=\"color:#333333;\">" +
                "Hello,</h3><p style=\"color:#666666;\">" +
                "You have requested a password reset. " +
                "Your new password is: <strong>" + newPassword +
                "</strong></p><p style=\"color:#666666;\">" +
                "Please change it after logging in.</p>" +
                "<p style=\"margin-top:20px;font-size:12px;color:#aaaaaa;text-align:center;\">" +
                "If you did not request a password reset," +
                " please ignore this email or contact us if you have any questions." +
                "</p></div></body></html>";

        emailService.send(emailDTO.getEmail(), "FoxHub - Password reset", emailBody);

        return ResponseEntity.ok().build();
    }

    @GetMapping("verify-email/{token}")
    public ResponseEntity<?> verify(@PathVariable String token) {
        User user = userService.getUserByVerificationToken(token);

        if (user != null && user.getVerificationToken().equals(token)) {
            user.setVerified(true);
            userService.saveUser(user);
            String responseHtml = "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\">" +
                    "<title>Email Verification Successful</title>" +
                    "<style>body {font-family: Arial, sans-serif; text-align: center;} " +
                    "h2 {color: #4CAF50;} p {color: #666666; text-decoration: none;} " +
                    "p a {color: #666666; text-decoration: none;} " +
                    "img {margin-top: 30px;}</style></head><body>" +
                    "<h2>Email verification successful</h2>" +
                    "<p><a href=\"http://foxhub.gfapp.eu/login\">Continue to login</a>" +
                    "</p><div><img " +
                    "src=\"https://uploads-ssl.webflow.com/5a8e9877a63d300001a1b0bc/64831b7b4d0859996e81ed15_corporate%20logo%20c.png\"" +
                    " alt=\"Logo\"></div></body></html>";
            return ResponseEntity.ok(responseHtml);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid verification token");
    }
}