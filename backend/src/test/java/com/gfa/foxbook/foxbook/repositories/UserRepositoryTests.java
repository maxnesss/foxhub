package com.gfa.foxbook.foxbook.repositories;

import com.gfa.foxbook.foxbook.models.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;



    @Test
    public void UserRepository_SaveAll_ReturnSavedUser() {
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("qwe123")
                .build();

        User savedUser = userRepository.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void UserRepository_GetAll_ReturnMoreThanOneUser() {
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("qwe123")
                .build();

        User user2 = User.builder()
                .firstName("Jane")
                .lastName("Doe")
                .email("jane@example.com")
                .password("qwe123")
                .build();

        userRepository.save(user);
        userRepository.save(user2);

        List<User> userList = userRepository.findAll();

        Assertions.assertThat(userList).isNotNull();
        Assertions.assertThat(userList.size()).isEqualTo(2);
    }

    @Test
    public void UserRepository_FindById_ReturnUser() {
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("qwe123")
                .build();

        userRepository.save(user);

        Optional<User> userSave = Optional.of(userRepository.findById(user.getId()).get());

        Assertions.assertThat(userSave).isNotNull();
    }

    @Test
    public void UserRepository_UpdateUser_ReturnUserNotNull() {
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("qwe123")
                .build();

        userRepository.save(user);

        User userSave = userRepository.getByNickname("john-doe");
        userSave.setFirstName("Joseph");
        userSave.setLastName("Coolio");

        User updatedUser = userRepository.save(userSave);

        Assertions.assertThat(updatedUser.getFirstName()).isNotNull();
        Assertions.assertThat(updatedUser.getLastName()).isNotNull();
    }

    @Test
    public void UserRepository_UserDelete_ReturnUserIsEmpty() {
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("qwe123")
                .build();

        userRepository.save(user);

        userRepository.deleteById(user.getId());
        Optional<User> userReturn = userRepository.findById(user.getId());

        Assertions.assertThat(userReturn).isEmpty();
    }

    @Test
    public void UserRepository_FindByEmail_ReturnUserNotNull() {
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("qwe123")
                .build();

        userRepository.save(user);

        Optional<User> userSave = userRepository.findByEmail("john@example.com");

        Assertions.assertThat(userSave).isPresent();
    }

    @Test
    public void UserRepository_GetByNickname_ReturnUserNotNull() {

        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("qwe123")
                .build();

        userRepository.save(user);

        Optional<User> userSave = Optional.ofNullable(userRepository.getByNickname(user.getNickname()));

        Assertions.assertThat(userSave).isPresent();
    }

    @Test
    public void UserRepository_FindByNickname_ReturnUserNotNull() {
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("qwe123")
                .build();

        userRepository.save(user);

        User userSave = userRepository.getByNickname("john-doe");

        Assertions.assertThat(userSave).isNotNull();
    }

    @Test
    public void UserRepository_ExistsByNickname_ReturnUserNotNull() {
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("qwe123")
                .build();

        userRepository.save(user);

        boolean existsByEmail = userRepository.existsByNickname("john-doe");

        Assertions.assertThat(existsByEmail).isTrue();
    }

    @Test
    public void UserRepository_ExistsByEmail_ReturnUserNotNull() {
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("qwe123")
                .build();

        userRepository.save(user);

        boolean existsByEmail = userRepository.existsByEmail("john@example.com");

        Assertions.assertThat(existsByEmail).isTrue();
    }

    @Test
    public void UserRepository_FindByFirstNameContainingIgnoreCase_ReturnMatchingUsers() {
        User user1 = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("qwe123")
                .build();
        User user2 = User.builder()
                .firstName("Jane")
                .lastName("Doe")
                .email("jane@example.com")
                .password("qwe123")
                .build();

        userRepository.saveAll(List.of(user1, user2));

        List<User> foundUsers = userRepository.findByFirstNameContainingIgnoreCase("John");

        Assertions.assertThat(foundUsers).isNotEmpty();
        Assertions.assertThat(foundUsers.size()).isEqualTo(1);
    }

    @Test
    public void UserRepository_FindByLastNameContainingIgnoreCase_ReturnMatchingUsers() {
        User user1 = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("qwe123")
                .build();
        User user2 = User.builder()
                .firstName("Jane")
                .lastName("Doe")
                .email("jane@example.com")
                .password("qwe123")
                .build();

        userRepository.saveAll(List.of(user1, user2));

        List<User> foundUsers = userRepository.findByLastNameContainingIgnoreCase("Doe");

        Assertions.assertThat(foundUsers).isNotEmpty();
        Assertions.assertThat(foundUsers.size()).isEqualTo(2);
    }

    @Test
    public void UserRepository_FindByNicknameContainingIgnoreCase_ReturnMatchingUsers() {
        User user1 = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("qwe123")
                .nickname("john-doe")
                .build();
        User user2 = User.builder()
                .firstName("Jane")
                .lastName("Doe")
                .email("jane@example.com")
                .password("qwe123")
                .nickname("jane-doe")
                .build();

        userRepository.saveAll(List.of(user1, user2));

        List<User> foundUsers = userRepository.findByNicknameContainingIgnoreCase("john-doe");

        Assertions.assertThat(foundUsers).isNotEmpty();
        Assertions.assertThat(foundUsers.size()).isEqualTo(1);
    }

    @Test
    public void UserRepository_GetUserByVerificationToken_ReturnUser() {
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("qwe123")
                .verificationToken("token123")
                .build();

        userRepository.save(user);

        User foundUser = userRepository.getUserByVerificationToken("token123");

        Assertions.assertThat(foundUser).isNotNull();
    }

    @Test
    public void UserRepository_FindByEmailAndYearOfBirth_ReturnUser() {
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("qwe123")
                .yearOfBirth(1990)
                .build();

        userRepository.save(user);

        Optional<User> foundUser = userRepository.findByEmailAndYearOfBirth("john@example.com", 1990);

        Assertions.assertThat(foundUser).isPresent();
    }

}
