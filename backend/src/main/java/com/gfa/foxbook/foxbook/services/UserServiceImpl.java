package com.gfa.foxbook.foxbook.services;

import com.gfa.foxbook.foxbook.models.dtos.UserBasicDTO;
import com.gfa.foxbook.foxbook.models.nonusermodels.Language;
import com.gfa.foxbook.foxbook.models.nonusermodels.Role;
import com.gfa.foxbook.foxbook.models.User;
import com.gfa.foxbook.foxbook.models.nonusermodels.Technology;
import com.gfa.foxbook.foxbook.repositories.LanguageRepository;
import com.gfa.foxbook.foxbook.repositories.TechnologyRepository;
import com.gfa.foxbook.foxbook.repositories.UserRepository;
import com.gfa.foxbook.foxbook.security.jwt.JwtUtils;
import com.gfa.foxbook.foxbook.services.interfaces.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TechnologyRepository technologyRepository;
    private final LanguageRepository languageRepository;
    private final JwtUtils jwtUtils;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public Optional<User> findById(Long id) {
        assert userRepository != null;
        return userRepository.findById(id);
    }

    @Override
    public void delete(User user) {
        assert userRepository != null;
        userRepository.delete(user);
    }

    @Override
    public User getUserByVerificationToken(String verificationToken) {
        return userRepository.getUserByVerificationToken(verificationToken);
    }

    @Override
    public List<User> getAll() {
        logger.info("Fetching all users from the repository");

        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            logger.warn("No users found in the repository");
        } else {
            logger.info("Found {} users in the repository", users.size());
        }

        return users;
    }

    @Override
    public Optional<User> findByNickname(String nickname) {
        return userRepository.findByNickname(nickname);
    }

    @Override
    public User getByNickname(String nickname) {
        return userRepository.getByNickname(nickname);
    }

    @Override
    public User upgradeUser(String nickname) {
        User user = userRepository.getByNickname(nickname);

        List<Role> roles = new ArrayList<>();
        Role adminRole = new Role("ADMIN");
        roles.add(adminRole);

        user.setRoles(roles);

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String name) {
        return userRepository.findByEmail(name);
    }

    @Override
    public Optional<User> findByEmailAndYearOfBirth(String email, int yearOfBirth) {
        return userRepository.findByEmailAndYearOfBirth(email, yearOfBirth);
    }

    @Override
    public UserBasicDTO convertToUserBasicDTO(User user) {
        UserBasicDTO userBasicDTO = new UserBasicDTO();
        userBasicDTO.setFirstName(user.getFirstName());
        userBasicDTO.setLastName(user.getLastName());
        userBasicDTO.setEmail(user.getEmail());
        return userBasicDTO;
    }

    @Override
    public List<User> searchUsers(String query) {
        List<User> usersByFirstName = userRepository.findByFirstNameContainingIgnoreCase(query);
        List<User> usersByLastName = userRepository.findByLastNameContainingIgnoreCase(query);
        List<User> usersByNickname = userRepository.findByNicknameContainingIgnoreCase(query);
        List<Technology> technologies = technologyRepository.findByNameContainingIgnoreCase(query);
        List<Language> languages = languageRepository.findByNameContainingIgnoreCase(query);

        //potential bug: if a user has a technology or language in their nickname, it will be returned twice

        return (List<User>) Stream.of(usersByFirstName, usersByLastName, usersByNickname, technologies, languages)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getCurrentUser(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        String nickname = jwtUtils.extractUsername(token);
        return userRepository.getByNickname(nickname);
    }

    @Override
    public void changeRole(User user) {
        String currentRole = user.getRoles().get(0).getName();

        if (currentRole.equals("USER")) {
            Role newRole = new Role("ADMIN");
            user.getRoles().set(0, newRole);
        }
        else if (currentRole.equals("ADMIN")) {
            Role newRole = new Role("USER");
            user.getRoles().set(0, newRole);
        }
        userRepository.save(user);
    }

    @Override
    public User updateProfile(User user, User userDTO) {
        if (userDTO.getFirstName() != null) user.setFirstName(userDTO.getFirstName());
        if (userDTO.getLastName() != null) user.setLastName(userDTO.getLastName());
        if (userDTO.getPhone() != null) user.setPhone(userDTO.getPhone());
        if (userDTO.getLocations() != null) user.setLocations(userDTO.getLocations());
        if (userDTO.getAbout() != null) user.setAbout(userDTO.getAbout());
        if (userDTO.getGitHub() != null) user.setGitHub(userDTO.getGitHub());
        if (userDTO.getLinkedin() != null) user.setLinkedin(userDTO.getLinkedin());
        if (userDTO.getFacebook() != null) user.setFacebook(userDTO.getFacebook());
        if (userDTO.getInstagram() != null) user.setInstagram(userDTO.getInstagram());
        if (userDTO.getLanguages() != null) user.setLanguages(userDTO.getLanguages());
        if (userDTO.getTechnologies() != null) user.setTechnologies(userDTO.getTechnologies());
        if (userDTO.getOptionalPage() != null) user.setOptionalPage(userDTO.getOptionalPage());
        if (userDTO.getPersonality() != null) user.setPersonality(userDTO.getPersonality());
        if (userDTO.getOneLineAbout() != null) user.setOneLineAbout(userDTO.getOneLineAbout());
        if (userDTO.getWorkPreference() != null) user.setWorkPreference(userDTO.getWorkPreference());
        if (userDTO.getColorPersonality() != null) user.setColorPersonality(userDTO.getColorPersonality());
        if (userDTO.getSpiritAnimal() != null) user.setSpiritAnimal(userDTO.getSpiritAnimal());

        user.setYearOfBirth(userDTO.getYearOfBirth());

        return userRepository.save(user);
    }
}
