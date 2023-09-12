package com.gfa.foxbook.foxbook.security.services;

import com.gfa.foxbook.foxbook.models.nonusermodels.Role;
import com.gfa.foxbook.foxbook.models.User;
import com.gfa.foxbook.foxbook.models.dtos.security.RegisterDto;
import com.gfa.foxbook.foxbook.models.nonusermodels.WorkPreference;
import com.gfa.foxbook.foxbook.repositories.RoleRepository;
import com.gfa.foxbook.foxbook.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.Collections;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class SecurityService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean userExistsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public void registerUser(RegisterDto registerDto) {
        User user = new User();
        user.setProfilePictureUrl("../../../assets/img/logo.png");
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setEmail(registerDto.getEmail());
        user.setVerified(false);
        user.setWorkPreference(WorkPreference.COMBINED);
        user.setVerificationToken(generateToken());
        user.setNickname(generateNickname(registerDto.getFirstName(), registerDto.getLastName()));
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        Role roles = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singletonList(roles));
        userRepository.save(user);
    }

    private String generateToken() {
        UUID tokenUUID = UUID.randomUUID();
        return tokenUUID.toString();
    }

    private String generateNickname(String fName, String lName) {
        fName = removeDiacritics(fName);
        lName = removeDiacritics(lName);

        if (userRepository.existsByNickname(fName + "-" + lName)) {
            int index = 1;
            while (userRepository.existsByNickname(fName + "-" + lName + index)) {
                index++;
            }
            return (fName + "-" + lName + index).toLowerCase();
        }
        return (fName + "-" + lName).toLowerCase();
    }

    private String removeDiacritics(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("");
    }
}
