package com.yummyyum.Repositories;
import com.yummyyum.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByUsername(String username);

    Boolean existsUserByUsername(String username);
}
