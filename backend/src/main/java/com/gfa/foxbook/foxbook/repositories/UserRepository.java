package com.gfa.foxbook.foxbook.repositories;

import com.gfa.foxbook.foxbook.models.User;
import com.gfa.foxbook.foxbook.models.nonusermodels.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    User getByNickname(String nickname);

    Optional<User> findByNickname(String nickname);

    boolean existsByNickname(String nickname);

    boolean existsByEmail(String email);

    List<User> findByFirstNameContainingIgnoreCase(String search);

    List<User> findByLastNameContainingIgnoreCase(String search);

    List<User> findByNicknameContainingIgnoreCase(String search);

    User getUserByVerificationToken(String verificationToken);

    Optional<User> findByEmailAndYearOfBirth(String email, int yearOfBirth);
}
