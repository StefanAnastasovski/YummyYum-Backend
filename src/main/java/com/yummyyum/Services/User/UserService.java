package com.yummyyum.Services.User;

import com.yummyyum.Model.User;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserByUsername(String username);

    Boolean existsUserByUsername(String username);

    User createNewUser(String firstName, String lastName,
                         String username, String password,
                       Timestamp signUpDate);

}
