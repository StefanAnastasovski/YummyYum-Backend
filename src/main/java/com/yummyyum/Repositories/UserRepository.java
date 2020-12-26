package com.yummyyum.Repositories;

import com.yummyyum.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByUsername(String username);

    @Query(value = "SELECT * FROM user JOIN email e ON user.id = e.id",
            nativeQuery = true)
    Optional<User> getUserByEmail(String email);

    Boolean existsUserByUsername(String username);


}
