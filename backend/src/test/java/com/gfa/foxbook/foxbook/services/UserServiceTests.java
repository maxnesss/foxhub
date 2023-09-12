package com.gfa.foxbook.foxbook.services;

import com.gfa.foxbook.foxbook.models.User;
import com.gfa.foxbook.foxbook.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void saveUser(){
        Long userId = 1L;
        User user = User.builder()
                .firstName("max")
                .lastName("nes")
                .email("max@gmail.com")
                .password("123456")
                .nickname("max-nes")
                .build();
        when(userRepository.save(user)).thenReturn(user);

        User returnUser = userRepository.save(user);

        assertThat(returnUser).isNotNull();
        assertThat(returnUser).isEqualTo(user);
    }

    @Test
    public void UserService_FindById_ReturnsUser() {

        Long userId = 1L;
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("qwe123")
                .nickname("john-doe")
                .build();

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        Optional<User> userReturn = userService.findById(userId);

        Assertions.assertThat(userReturn).isNotNull();
        assertThat(userReturn).isNotEmpty();
        assertThat(userReturn.get()).isEqualTo(user);
    }

    @Test
    public void UserService_Delete() {
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("qwe123")
                .nickname("john-doe")
                .build();

        userService.delete(user);

        verify(userRepository, times(1)).delete(user);
    }

    @Test
    public void UserService_SaveUser_ReturnsUser() {
        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .password("qwe123")
                .nickname("john-doe")
                .build();

        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        userService.saveUser(user);

        Assertions.assertThat(user).isNotNull();
    }

}
