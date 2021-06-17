package com.yummyyum.Repositories;

import com.yummyyum.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByUsername(String username);

    @Query(value = "SELECT * FROM user as u JOIN email e ON u.id = e.id where e.email = :email",
            nativeQuery = true)
    Optional<User> findUserByEmail(String email);

    Optional<User> findUserById(Long id);

    Boolean existsUserByUsername(String username);

}
